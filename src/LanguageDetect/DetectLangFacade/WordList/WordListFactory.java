package LanguageDetect.DetectLangFacade.WordList;

import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class WordListFactory {
    public WordList create(String listType, String string, String specialChars) {
        if(listType.equals("Fullword")) return new FullwordList(string, specialChars);
        else if(listType.equals("Trigram")) return new TrigramList(string, specialChars);
        else return null;
    }
    public WordList create(String listType, ArrayList<Word> wordlist) {
        if(listType.equals("Fullword")) return new FullwordList(wordlist);
        else if(listType.equals("Trigram")) return new TrigramList(wordlist);
        else return null;
    }
}
