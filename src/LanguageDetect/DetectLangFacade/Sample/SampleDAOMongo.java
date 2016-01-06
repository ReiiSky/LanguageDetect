package LanguageDetect.DetectLangFacade.Sample;

import LanguageDetect.DetectLangFacade.WordList.Word;
import LanguageDetect.DetectLangFacade.WordList.WordList;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * Data Access Object Pattern Implementation for MongoDB.
 */
public class SampleDAOMongo implements SampleDAO {
    MongoClient client = new MongoClient(); //Default MongoClient.
    MongoDatabase database = client.getDatabase("langdetect"); //MongoDatabase.
    MongoCollection<Document> sampleCollection = database.getCollection("samples"); //Samples collection.

    /**
     * Gets all samples from the database and puts them in an ArrayList.
     *
     * @return
     */
    @Override
    public ArrayList<Sample> getAllSamples() {
        try{
            ArrayList<Sample> allSamples = new ArrayList<>();
            FindIterable<Document> iterable = sampleCollection.find();
            iterable.forEach(new Block<Document>() {
                @Override
                public void apply(Document document) {
                    allSamples.add(new Sample(
                            document.getObjectId("_id"),
                            document.getString("language"),
                            document.getString("specialChars"),
                            convertDoclistToWordlist("Fullword",(ArrayList<Document>)document.get("fullword")),
                            convertDoclistToWordlist("Trigram",(ArrayList<Document>)document.get("trigram"))
                    ));
                }
            });
            return allSamples;
        }catch (MongoClientException e){
            return null;
        }
    }

    /**
     * Gets the sample by its language.
     *
     * @param language
     * @return
     */
    @Override
    public Sample getSample(String language) {
        try{
            final Sample[] sample = {null};
            FindIterable<Document> iterable = sampleCollection.find(new Document("language", language));
            iterable.forEach(new Block<Document>() {
                @Override
                public void apply(Document document) {
                    sample[0] = new Sample(
                            document.getObjectId("_id"),
                            document.getString("language"),
                            document.getString("specialChars"),
                            convertDoclistToWordlist("Fullword",(ArrayList<Document>)document.get("fullword")),
                            convertDoclistToWordlist("Trigram",(ArrayList<Document>)document.get("trigram"))
                    );
                }
            });
            return sample[0];
        }catch (MongoClientException e){
            return null;
        }
    }

    /**
     * Adds a new sample to the database.
     *
     * @param sample
     * @return
     */
    @Override
    public boolean addSample(Sample sample) {
        try{
            Document doc = new Document("language", sample.getLanguage())
                    .append("specialChars", sample.getSpecialChars())
                    .append("fullword", convertWordlistToDoclist(sample.getFullword().getList()))
                    .append("trigram", convertWordlistToDoclist(sample.getTrigram().getList()));
            sampleCollection.insertOne(doc);
            return true;
        }catch (MongoClientException e){
            return false;
        }
    }

    /**
     * Updates the given sample.
     *
     * @param sample
     * @return
     */
    @Override
    public boolean updateSample(Sample sample) {
        try{
            deleteSample(sample.getLanguage());
            addSample(sample);
            return true;
        }catch (MongoClientException e){
            return false;
        }
    }

    /**
     * Deletes the given sample from database.
     *
     * @param language
     * @return
     */
    @Override
    public boolean deleteSample(String language) {
        try{
            sampleCollection.deleteOne(new Document("language", language));
            return true;
        }catch (MongoWriteException e)
        {
            System.out.print(e.toString());
            return false;
        }
    }

    /**
     * Converts the ArrayList of Documents to WordList.
     *
     * @param listType
     * @param docs
     * @return
     */
    private WordList convertDoclistToWordlist(String listType, ArrayList<Document> docs){
        ArrayList<Word> wordlist = new ArrayList<>();
        for(Document doc : docs){
            wordlist.add(new Word(doc.getString("string"), doc.getInteger("count")));
        }
        return new WordListFactory().create(listType, wordlist);
    }

    /**
     * Converts the ArrayList of Words to ArrayList of Documents.
     *
     * @param wordlist
     * @return
     */
    private ArrayList<Document> convertWordlistToDoclist (ArrayList<Word> wordlist){
        ArrayList<Document> doclist = new ArrayList<>();
        for(Word word : wordlist){
            doclist.add(new Document("string", word.getString()).append("count", word.getCount()));
        }
        return doclist;
    }
}
