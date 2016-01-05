package LanguageDetect.DetectLangFacade.Sample;

import LanguageDetect.DetectLangFacade.WordList.Word;
import LanguageDetect.DetectLangFacade.WordList.WordList;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Tests Sample Class.
 *
 * Created by MuratCan on 5.1.2016.
 */
public class SampleTest {

    @Test
    public void testUpdateFullword() throws Exception {
        String testString = "JUnit ile test yapıyorum";
        String testUpdate = "Yine JUnit kullanıyoruz";
        String specialChars = "ğĞçÇşŞüÜöÖıİ";
        Sample sample = new Sample();
        sample.setFullword(new WordListFactory().create("Fullword", testString, specialChars));
        sample.updateFullword(new WordListFactory().create("Fullword", testUpdate, specialChars));
        WordList updated = sample.getFullword();
        WordList expected = new WordListFactory().create("Fullword", testString + " " + testUpdate, specialChars);

        assertArrayEquals(expected.getList().toArray(), updated.getList().toArray());
    }

    @Test
    public void testUpdateTrigram() throws Exception {
        String testString = "Testing";
        String testUpdate = "JUnit";
        String specialChars = "ğĞçÇşŞüÜöÖıİ";
        Sample sample = new Sample();
        sample.setTrigram(new WordListFactory().create("Trigram", testString, specialChars));

        sample.updateTrigram(new WordListFactory().create("Trigram", testUpdate, specialChars));

        WordList updated = sample.getTrigram();

        WordList expected = new WordListFactory().create("Trigram", testString, specialChars);
        expected.getList().add(new Word("jun"));
        expected.getList().add(new Word("uni"));
        expected.getList().add(new Word("nit"));

        assertArrayEquals(expected.getList().toArray(), updated.getList().toArray());
    }
}