package LanguageDetect.DetectLangFacade.Sample;

import LanguageDetect.DetectLangFacade.WordList.WordList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class Sample {
    private String language;
    private String specialChars;
    private WordList fullWord;
    private WordList trigramWord;

    public Sample(String language,String specialChars, WordList fullWord, WordList trigramWord) {
        this.language = language;
        this.specialChars = specialChars;
        this.trigramWord = trigramWord;
        this.fullWord = fullWord;
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
        return fullWord;
    }
    public void setFullWord(WordList fullWord) {
        this.fullWord = fullWord;
    }

    public WordList getTrigramWord() {
        return trigramWord;
    }
    public void setTrigramWord(WordList trigramWord) {
        this.trigramWord = trigramWord;
    }
}
