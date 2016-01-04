package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;

import java.util.ArrayList;

/**
 * ParsingType Interface for Parsing Strategy.
 *
 * Created by MuratCan on 3.1.2016.
 */
public interface ParsingType {
    /**
     * Parses the given string according to the given special characters
     * and returns the ArrayList of Word's.
     *
     * @param string
     * @param specialChars
     * @return
     */
    ArrayList<Word> parse(String string, String specialChars);
}

