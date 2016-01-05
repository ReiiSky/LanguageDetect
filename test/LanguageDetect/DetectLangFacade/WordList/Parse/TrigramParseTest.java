package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by MuratCan on 5.1.2016.
 */
public class TrigramParseTest {

    @Test
    public void testParse() throws Exception {
        String testString = "Fıstıkçı şahap öğlen";
        String specialChars = "ğĞçÇşŞüÜöÖıİ";
        ArrayList<Word> expectedArray = expectedArray();
        ArrayList<Word> result = new TrigramParse().parse(testString, specialChars);

        assertArrayEquals(expectedArray.toArray(), result.toArray());
    }

    private ArrayList<Word> expectedArray(){
        String testString = "Fıstıkçı şahap öğlen";
        ArrayList<Word> expectedArray = new ArrayList<>();
        expectedArray.add(new Word("fıs"));
        expectedArray.add(new Word("ıst"));
        expectedArray.add(new Word("stı"));
        expectedArray.add(new Word("tık"));
        expectedArray.add(new Word("ıkç"));
        expectedArray.add(new Word("kçı"));
        expectedArray.add(new Word("çı_"));
        expectedArray.add(new Word("ı_ş"));
        expectedArray.add(new Word("_şa"));
        expectedArray.add(new Word("şah"));
        expectedArray.add(new Word("aha"));
        expectedArray.add(new Word("hap"));
        expectedArray.add(new Word("ap_"));
        expectedArray.add(new Word("p_ö"));
        expectedArray.add(new Word("_öğ"));
        expectedArray.add(new Word("öğl"));
        expectedArray.add(new Word("ğle"));
        expectedArray.add(new Word("len"));
        Collections.sort(expectedArray, Collections.reverseOrder());
        return expectedArray;
    }
}