package LanguageDetect.DetectLangFacade.Sample;

import LanguageDetect.DetectLangFacade.WordList.Word;
import LanguageDetect.DetectLangFacade.WordList.WordList;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class Sample {
    private ObjectId id;
    private String language;
    private String specialChars;
    private WordList fullword;
    private WordList trigram;

    public Sample(){
        this.id = null;
        this.language = null;
        this.specialChars = null;
        this.fullword = null;
        this.trigram = null;
    }
    public Sample(ObjectId id,String language,String specialChars, WordList fullword, WordList trigram) {
        this.id = id;
        this.language = language;
        this.specialChars = specialChars;
        this.fullword = fullword;
        this.trigram = trigram;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSpecialChars() {
        return specialChars;
    }
    public void setSpecialChars(String specialChars) { this.specialChars = specialChars; }

    public WordList getFullword() {
        return fullword;
    }
    public void setFullword(WordList fullWord) {
        this.fullword = fullWord;
    }

    public WordList getTrigram() { return trigram; }
    public void setTrigram(WordList trigramWord) {
        this.trigram = trigramWord;
    }

    public void updateFullword (WordList fullwordlist){
        for(Word w : fullwordlist.getList()){
            if(this.fullword.getList().contains(w))
                this.fullword.getList().get(this.fullword.getList().indexOf(w)).incCount();
            else
                this.fullword.getList().add(w);
        }
        Collections.sort(this.fullword.getList(), Collections.reverseOrder());
    }

    public void updateTrigram(WordList trigramlist){
        for(Word w : trigramlist.getList()){
            if(this.trigram.getList().contains(w))
                this.trigram.getList().get(this.trigram.getList().indexOf(w)).incCount();
            else
                this.trigram.getList().add(w);
        }
        Collections.sort(this.trigram.getList(), Collections.reverseOrder());
    }
}
