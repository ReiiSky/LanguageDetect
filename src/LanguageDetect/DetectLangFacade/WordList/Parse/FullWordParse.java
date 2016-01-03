package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class FullWordParse implements ParsingType {
    @Override
    public ArrayList<Word> parse(String string) {
        String[] splitString = string.replaceAll("[^a-zA-ZğüşıöçĞÜŞİÖÇ\\s]"," ").toLowerCase().split("\\s+");
        ArrayList<Word> arrayList = new ArrayList<Word>();
        Word word;
        for(String s : splitString){
            word = new Word(s);
            if(arrayList.contains(word)) arrayList.get(arrayList.indexOf(word)).incCount();
            else arrayList.add(word);
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        return arrayList;
    }
}
