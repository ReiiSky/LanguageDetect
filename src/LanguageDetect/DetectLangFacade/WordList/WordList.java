package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.ParsingType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Abstract WordList class.
 * Keeps Word objects in a list.
 */
public abstract class WordList {
    private ArrayList<Word> list;
    private ParsingType parsingType;

    //ArrayList<Word> getter, setter.
    public ArrayList<Word> getList() { return list; }
    public void setList(ArrayList<Word> list) { this.list = list; }
    //ParsingType getter, setter.
    public ParsingType getParsingType() { return parsingType; }
    public void setParsingType(ParsingType parsingType) { this.parsingType = parsingType; }
}
