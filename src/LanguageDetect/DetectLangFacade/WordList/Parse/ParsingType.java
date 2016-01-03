package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;

import java.util.ArrayList;

/**
 * Created by MuratCan on 3.1.2016.
 */
public interface ParsingType {
    ArrayList<Word> parse(String string);
}

