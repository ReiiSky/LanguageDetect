package LanguageDetect.DetectLangFacade.WordList;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests Word Object.
 *
 * Created by MuratCan on 5.1.2016.
 */
public class WordTest {
    /**
     * Tests the increment of the Word's count.
     *
     * @throws Exception
     */
    @Test
    public void testIncCount() throws Exception {
        Word word = new Word("muro", 5);
        int initialCount = word.getCount();
        word.incCount();
        int expectedCount = initialCount + 1;
        int resultCount = word.getCount();

        assertEquals(expectedCount,resultCount);
    }

    /**
     * Tests the addition of count to Word's count.
     *
     * @throws Exception
     */
    @Test
    public void testAddCount() throws Exception {
        Word word = new Word("muro", 5);
        int initialCount = word.getCount();
        word.addCount(25);
        int expectedCount = initialCount + 25;
        int resultCount = word.getCount();

        assertEquals(expectedCount, resultCount);
    }

    /**
     * Tests Word's overridden equals() method.
     *
     * @throws Exception
     */
    @Test
    public void testEquals() throws Exception {
        Word firstWord = new Word("muro", 5);
        Word secondWord = new Word("muro", 3);

        assertTrue(firstWord.equals(secondWord));
    }

    @Test
    public void testCompareTo() throws Exception {
        Word firstWord = new Word("muro", 5);
        Word secondWord = new Word("muro", 4);
        Word thirdWord = new Word("muro", 6);
        Word forthWord = new Word("muro", 5);
        int[] expected = new int[3];
        expected[0] = 1;
        expected[1] = -1;
        expected[2] = 0;
        int[] result = new int[3];
        result[0] = firstWord.compareTo(secondWord);
        result[1] = firstWord.compareTo(thirdWord);
        result[2] = firstWord.compareTo(forthWord);

        assertArrayEquals(expected, result);
    }
}