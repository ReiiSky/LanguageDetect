package LanguageDetect.DetectLangFacade.Sample;

import LanguageDetect.DetectLangFacade.WordList.WordList;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

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

    public WordList getFullWord() {
        return fullword;
    }
    public void setFullWord(WordList fullWord) {
        this.fullword = fullWord;
    }

    public WordList getTrigramWord() {
        return trigram;
    }
    public void setTrigramWord(WordList trigramWord) {
        this.trigram = trigramWord;
    }
}
