package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Fullword Parsing Type. Implements ParsingType Interface.
 *
 * Created by MuratCan on 3.1.2016.
 */
public class TrigramParse implements ParsingType {
    /**
     * Parses the given string to its trigram words according to the given special
     * characters.
     *
     * @param string
     * @param specialChars
     * @return
     */
    @Override
    public ArrayList<Word> parse(String string, String specialChars) {
        String regexSpace = "[^a-zA-Z" + specialChars + "\\s+]";//setting regex for replace operation.
        String regexUnder = "[^a-zA-Z" + specialChars + "]";//setting regex for the second replace operation.
        string = string.toLowerCase().replaceAll(regexSpace," ")
                .replaceAll("\\s+", " ").trim()
                .replaceAll(regexUnder,"_");
        ArrayList<Word> arrayList = new ArrayList<Word>();
        Word word;
        for(int i = 0; i < string.length()-2; i++){
            word = new Word(string.substring(i, i+3));
            if(arrayList.contains(word)) arrayList.get(arrayList.indexOf(word)).incCount();
            else arrayList.add(word);
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        if(arrayList.size() > 50) arrayList.subList(50, arrayList.size()).clear();
        return arrayList;
    }
}
