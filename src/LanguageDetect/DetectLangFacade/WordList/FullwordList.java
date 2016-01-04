package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.FullwordParse;

import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class FullwordList extends WordList {
    public FullwordList(ArrayList<Word> wordlist) {
        setParsingType(new FullwordParse());
        wordlist.subList(50, wordlist.size()).clear();
        setList(wordlist);
    }
    public FullwordList(String string, String specialChars) {
        setParsingType(new FullwordParse());
        setList(getParsingType().parse(string, specialChars));
    }
}
