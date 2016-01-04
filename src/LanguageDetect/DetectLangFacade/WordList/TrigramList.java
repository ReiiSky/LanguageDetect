package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.TrigramParse;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class TrigramList extends WordList {
    public TrigramList(ArrayList<Word> wordlist) {
        setParsingType(new TrigramParse());
        setList(wordlist);
    }
    public TrigramList(String string, String specialChars) {
        setParsingType(new TrigramParse());
        setList(getParsingType().parse(string, specialChars));
    }
}
