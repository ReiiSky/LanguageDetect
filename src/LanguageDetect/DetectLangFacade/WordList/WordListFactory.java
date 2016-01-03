package LanguageDetect.DetectLangFacade.WordList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class WordListFactory {
    public WordList createList(String parseType, String string) {
        if(parseType.equals("Fullword")) return new FullwordList(string);
        else if(parseType.equals("Trigram")) return new TrigramList(string);
        else return null;
    }
}
