package LanguageDetect.DetectLangFacade.WordList.Parse;

import LanguageDetect.DetectLangFacade.WordList.Word;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Tests fullword parsing.
 *
 * Created by MuratCan on 5.1.2016.
 */
public class FullwordParseTest {

    @Test
    public void testParse() throws Exception {
        String testString = "Fıstıkçı şahap öğlen";
        String specialChars = "ğĞçÇşŞüÜöÖıİ";
        ArrayList<Word> expectedArray = expectedArray();
        ArrayList<Word> result = new FullwordParse().parse(testString, specialChars);

        assertArrayEquals(expectedArray.toArray(), result.toArray());
    }

    private ArrayList<Word> expectedArray(){
        String testString = "Fıstıkçı şahap öğlen";
        ArrayList<Word> expectedArray = new ArrayList<>();
        expectedArray.add(new Word("fıstıkçı"));
        expectedArray.add(new Word("şahap"));
        expectedArray.add(new Word("öğlen"));
        Collections.sort(expectedArray, Collections.reverseOrder());
        return expectedArray;
    }
}