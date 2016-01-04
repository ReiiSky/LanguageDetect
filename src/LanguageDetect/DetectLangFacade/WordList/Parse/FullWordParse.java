package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Trigram Parsing Type. Implements ParsingType Interface.
 *
 * Created by MuratCan on 3.1.2016.
 */
public class FullwordParse implements ParsingType {
    /**
     * Parses the given string to its fullwords according to the given special
     * characters.
     *
     * @param string
     * @param specialChars
     * @return
     */
    @Override
    public ArrayList<Word> parse(String string, String specialChars) {
        String regex = "[^a-zA-Z" + specialChars + "\\s]";//adding specialCharacters to the regex.
        //Replaces all characters that are non-alphabetic or not in the specialChars with space character.
        //Trims trailing spaces.
        //Converts string to lowercase.
        //Splits string by each space or new line character.
        String[] splitString = string.replaceAll(regex," ").trim().toLowerCase().split("\\s+");
        ArrayList<Word> arrayList = new ArrayList<>();
        Word word;
        for(String s : splitString){ //adds each string to the list.
            word = new Word(s);
            //if the string is already in the list, increments its count by one.
            if(arrayList.contains(word)) arrayList.get(arrayList.indexOf(word)).incCount();
            else arrayList.add(word);
        }
        Collections.sort(arrayList, Collections.reverseOrder()); //sorts the list descending.
        if(arrayList.size() > 50) arrayList.subList(50, arrayList.size()).clear();//shrinks the list to 50 members.
        return arrayList;
    }
}
