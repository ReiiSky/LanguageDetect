package LanguageDetect.DetectLangFacade;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests Facade.
 */
public class DetectLangFacadeTest {
    @Test
    public void testJaccardSimilarity() throws Exception {
        String subject = "JUnit ile test yapıyorum";
        DetectLangFacade facade = new DetectLangFacade(subject);
        String expected = "Türkçe";
        String result = facade.getResult();

        assertEquals(expected, result);
    }
}