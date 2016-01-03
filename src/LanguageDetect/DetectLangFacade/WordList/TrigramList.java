package LanguageDetect.DetectLangFacade.WordList;

import LanguageDetect.DetectLangFacade.WordList.Parse.TrigramParse;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class TrigramList extends WordList {
    public TrigramList(String string) {
        setParsingType(new TrigramParse());
        setList(getParsingType().parse(string));
    }
}
