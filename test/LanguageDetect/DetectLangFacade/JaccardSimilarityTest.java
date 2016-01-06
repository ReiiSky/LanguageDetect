package LanguageDetect.DetectLangFacade;

import LanguageDetect.DetectLangFacade.Sample.Sample;
import LanguageDetect.DetectLangFacade.WordList.WordList;
import LanguageDetect.DetectLangFacade.WordList.WordListFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests Jaccard Similarity Algorithm
 */
public class JaccardSimilarityTest {
    @Test
    public void testJaccardSimilarity() throws Exception {
        String sampleString = "JUnit ile test yapıyorum";
        String subjectString = "JUnit işleri kolaylaştırıyor";
        String specialChars = "ğĞçÇşŞüÜöÖıİ";
        double intersection = 1;
        double union = 6;
        WordList sample = new WordListFactory().create("Fullword", sampleString, specialChars);
        WordList subject = new WordListFactory().create("Fullword", subjectString, specialChars);
        Double expected = new Double(intersection / union);
        Double result = new JaccardSimilarity(sample, subject).getResult();

        assertEquals(expected,result);
    }
}