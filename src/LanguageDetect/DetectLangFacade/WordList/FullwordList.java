package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.FullwordParse;

import java.util.ArrayList;

/**
 * Subclass of the Abstract WordList Class.
 */
public class FullwordList extends WordList {
    /**
     * Sets the given WordList as its Wordlist
     * and Sets the ParsingType for future change.
     *
     * @param wordlist
     */
    public FullwordList(ArrayList<Word> wordlist) {
        setParsingType(new FullwordParse());
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
    public FullwordList(String string, String specialChars) {
        setParsingType(new FullwordParse());
        setList(getParsingType().parse(string, specialChars));
    }
}
