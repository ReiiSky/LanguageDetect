package LanguageDetect.DetectLangFacade.Sample;

import LanguageDetect.DetectLangFacade.WordList.Word;
import LanguageDetect.DetectLangFacade.WordList.WordList;
import org.bson.types.ObjectId;
import java.util.Collections;

/**
 * Sample Class.
 * Contains sample data of trigram and fullword lists of its language.
 * Uses WordList Factory.
 *
 * Created by MuratCan on 3.1.2016.
 */
public class Sample {
    private ObjectId id;
    private String language;
    private String specialChars;
    private WordList fullword;
    private WordList trigram;

    /**
     * Default constructor.
     */
    public Sample(){
        this.id = null;
        this.language = null;
        this.specialChars = null;
        this.fullword = null;
        this.trigram = null;
    }

    /**
     * Constructor.
     *
     * @param id
     * @param language
     * @param specialChars
     * @param fullword
     * @param trigram
     */
    public Sample(ObjectId id,String language,String specialChars, WordList fullword, WordList trigram) {
        this.id = id;
        this.language = language;
        this.specialChars = specialChars;
        this.fullword = fullword;
        this.trigram = trigram;
    }
    //ObjectId getter,setter.
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    //Language getter, setter.
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    //Special Characters getter, setter.
    public String getSpecialChars() { return specialChars; }
    public void setSpecialChars(String specialChars) { this.specialChars = specialChars; }
    //Fullword List getter, setter.
    public WordList getFullword() { return fullword; }
    public void setFullword(WordList fullWord) { this.fullword = fullWord; }
    //Trigram List getter, setter.
    public WordList getTrigram() { return trigram; }
    public void setTrigram(WordList trigramWord) { this.trigram = trigramWord; }

    /**
     * Updates Sample's Fullword List.
     *
     * @param fullwordlist
     */
    public void updateFullword (WordList fullwordlist){
        for(Word w : fullwordlist.getList()){
            if(this.fullword.getList().contains(w))
                this.fullword.getList().get(this.fullword.getList().indexOf(w)).addCount(w.getCount());
            else
                this.fullword.getList().add(w);
        }
        Collections.sort(this.fullword.getList(), Collections.reverseOrder());
        if(this.fullword.getList().size() > 50) this.fullword.getList().subList(50, this.fullword.getList().size()).clear();
    }

    /**
     * Updates Sample's Trigram list.
     *
     * @param trigramlist
     */
    public void updateTrigram(WordList trigramlist){
        for(Word w : trigramlist.getList()){
            if(this.trigram.getList().contains(w))
                this.trigram.getList().get(this.trigram.getList().indexOf(w)).addCount(w.getCount());
            else
                this.trigram.getList().add(w);
        }
        Collections.sort(this.trigram.getList(), Collections.reverseOrder());
        if(this.fullword.getList().size() > 50) this.fullword.getList().subList(50, this.fullword.getList().size()).clear();
    }
}
