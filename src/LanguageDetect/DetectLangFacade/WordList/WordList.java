package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.ParsingType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MuratCan on 3.1.2016.
 */
public abstract class WordList {
    private ArrayList<Word> list;
    private ParsingType parsingType;

    public ArrayList<Word> getList() { return list; }
    public ParsingType getParsingType() { return parsingType; }
    protected void setList(ArrayList<Word> list) { this.list = list; }
    protected void setParsingType(ParsingType parsingType) { this.parsingType = parsingType; }
}
