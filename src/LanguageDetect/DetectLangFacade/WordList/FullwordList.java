package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.FullWordParse;

import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class FullwordList extends WordList {
    public FullwordList(ArrayList<Word> wordlist) {
        setParsingType(new FullWordParse());
        setList(wordlist);
    }
    public FullwordList(String string, String specialChars) {
        setParsingType(new FullWordParse());
        setList(getParsingType().parse(string, specialChars));
    }
}
