package LanguageDetect.DetectLangFacade.Subject;

import LanguageDetect.DetectLangFacade.WordList.WordList;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class Subject {
    private String context;
    private WordList fullword;
    private WordList trigram;

    public Subject(String context,String specialChars) {
        this.context = context;
        setFullword(new WordListFactory().create("Fullword", context, specialChars));
        setTrigram(new WordListFactory().create("Trigram", context, specialChars));
    }

    public String getContext() { return context; }
    public void setContext(String context, String specialChars) {
        this.context = context;
        setFullword(new WordListFactory().create("Fullword", context, specialChars));
        setTrigram(new WordListFactory().create("Trigram", context, specialChars));
    }

    public WordList getFullword() { return fullword; }
    private void setFullword(WordList fullword) { this.fullword = fullword; }

    public WordList getTrigram() { return trigram; }
    private void setTrigram(WordList trigram) { this.trigram = trigram; }
}
