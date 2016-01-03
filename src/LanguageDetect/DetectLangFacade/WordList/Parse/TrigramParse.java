package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;

import java.util.ArrayList;
import java.util.Collections;

public class TrigramParse implements ParsingType {

    @Override
    public ArrayList<Word> parse(String string) {
        string = string.toLowerCase().replaceAll("[^a-zA-ZğüşıöçĞÜŞİÖÇ\\s]"," ");
        string = string.replaceAll("\\s+", " ").trim();
        string = string.replaceAll("[^a-zA-ZğüşıöçĞÜŞİÖÇ]","_");
        ArrayList<Word> arrayList = new ArrayList<Word>();
        Word word;
        for(int i = 0; i < string.length()-2; i++){
            word = new Word(string.substring(i, i+3));
            if(arrayList.contains(word)) arrayList.get(arrayList.indexOf(word)).incCount();
            else arrayList.add(word);
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        return arrayList;
    }
}
