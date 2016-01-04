package LanguageDetect.DetectLangFacade.Subject;

import LanguageDetect.DetectLangFacade.WordList.WordList;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;

/**
 * Subject class.
 * Uses WordList Factory.
 *
 * Created by MuratCan on 3.1.2016.
 */
public class Subject {
    private String context;
    private WordList fullword;
    private WordList trigram;

    /**
     * Constructor.
     * Sets its fullword and trigram lists.
     *
     * @param context
     * @param specialChars
     */
    public Subject(String context,String specialChars) {
        this.context = context;
        setFullword(new WordListFactory().create("Fullword", context, specialChars));
        setTrigram(new WordListFactory().create("Trigram", context, specialChars));
    }
    //Context getter, setter.
    public String getContext() { return context; }
    public void setContext(String context, String specialChars) {
        this.context = context;
        //sets the trigram and fullword lists again.
        setFullword(new WordListFactory().create("Fullword", context, specialChars));
        setTrigram(new WordListFactory().create("Trigram", context, specialChars));
    }
    //Fullword List getter, setter.
    public WordList getFullword() { return fullword; }
    private void setFullword(WordList fullword) { this.fullword = fullword; }
    //Trigram List getter, setter.
    public WordList getTrigram() { return trigram; }
    private void setTrigram(WordList trigram) { this.trigram = trigram; }
}
