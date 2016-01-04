package LanguageDetect.DetectLangFacade.WordList;

import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class WordListFactory {
    public WordList createList(String listType, String string) {
        if(listType.equals("Fullword")) return new FullwordList(string);
        else if(listType.equals("Trigram")) return new TrigramList(string);
        else return null;
    }
    public WordList createList(String listType, ArrayList<Word> wordlist) {
        if(listType.equals("Fullword")) return new FullwordList(wordlist);
        else if(listType.equals("Trigram")) return new TrigramList(wordlist);
        else return null;
    }
}
