package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by MuratCan on 3.1.2016.
 */
public class FullWordParse implements ParsingType {
    @Override
    public ArrayList<Word> parse(String string, String specialChars) {
        String regex = "[^a-zA-Z" + specialChars + "\\s]";
        String[] splitString = string.replaceAll(regex," ").trim().toLowerCase().split("\\s+");
        ArrayList<Word> arrayList = new ArrayList<>();
        Word word;
        for(String s : splitString){
            word = new Word(s);
            if(arrayList.contains(word)) arrayList.get(arrayList.indexOf(word)).incCount();
            else arrayList.add(word);
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        if(arrayList.size() > 50) arrayList.subList(50, arrayList.size()).clear();
        return arrayList;
    }
}
