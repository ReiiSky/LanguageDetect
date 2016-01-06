package LanguageDetect.DetectLangFacade.WordList;

import java.util.ArrayList;

/**
 * WordList Factory class that creates WordLists.
 */
public class WordListFactory {
    /**
     * Creates and returns a WordList subclass according to the given type string.
     * The subclass will parse given context according to specialChars and will be returned to the caller.
     * @param listType
     * @param string
     * @param specialChars
     * @return
     */
    public WordList create(String listType, String string, String specialChars) {
        if(listType.equals("Fullword")) return new FullwordList(string, specialChars);
        else if(listType.equals("Trigram")) return new TrigramList(string, specialChars);
        else return null;
    }

    /**
     * Creates and returns a WordList subclass according to the given type string.
     * The subclass will set given Word list as its list and will be returned to the caller.
     * @param listType
     * @param wordlist
     * @return
     */
    public WordList create(String listType, ArrayList<Word> wordlist) {
        if(listType.equals("Fullword")) return new FullwordList(wordlist);
        else if(listType.equals("Trigram")) return new TrigramList(wordlist);
        else return null;
    }
}
