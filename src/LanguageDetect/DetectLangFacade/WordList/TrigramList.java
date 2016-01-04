package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.TrigramParse;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Subclass of the Abstract WordList Class.
 *
 * Created by MuratCan on 3.1.2016.
 */
public class TrigramList extends WordList {
    /**
     * Sets the given WordList as its Wordlist
     * and Sets the ParsingType for future change.
     *
     * @param wordlist
     */
    public TrigramList(ArrayList<Word> wordlist) {
        setParsingType(new TrigramParse());
        wordlist.subList(50, wordlist.size()).clear();
        setList(wordlist);
    }

    /**
     * Sets the ParsingType and parses the given string
     * according to its ParsingType and the given special characters.
     *
     * @param string
     * @param specialChars
     */
    public TrigramList(String string, String specialChars) {
        setParsingType(new TrigramParse());
        setList(getParsingType().parse(string, specialChars));
    }
}
