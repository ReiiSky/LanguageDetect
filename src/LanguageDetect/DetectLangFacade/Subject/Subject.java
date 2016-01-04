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

    public Subject(String context) {
        this.context = context;
        setFullword(new WordListFactory().createList("Fullword", context));
        setTrigram(new WordListFactory().createList("Trigram", context));
    }

    public String getContext() { return context; }
    public void setContext(String context) {
        this.context = context;
        setFullword(new WordListFactory().createList("Fullword", context));
        setTrigram(new WordListFactory().createList("Trigram", context));
    }

    public WordList getFullword() { return fullword; }
    private void setFullword(WordList fullword) { this.fullword = fullword; }

    public WordList getTrigram() { return trigram; }
    private void setTrigram(WordList trigram) { this.trigram = trigram; }
}
