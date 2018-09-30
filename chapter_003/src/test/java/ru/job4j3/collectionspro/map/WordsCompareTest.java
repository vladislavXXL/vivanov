package ru.job4j3.collectionspro.map;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author v.ivanov
 * @version 1
 * @since 30.09.2018
 */
public class WordsCompareTest {

    /** WorpCompare class instance.*/
    private WordsCompare obj = new WordsCompare();

    /**
     * Method to check if words are complete equals.
     */
    @Test
    public void checkIfWordsCompleteEquals() {
        boolean result = obj.isCompleteEquals("Prosveschenie", "Prosveschenie");
        assertThat(result, is(true));
        result = obj.isCompleteEquals("mmm", "mmmmmmmm");
        assertThat(result, is(false));
    }

    /**
     * Method to check if words characters are equals.
     */
    @Test
    public void checkIfCharactersEquals() {
        boolean result = obj.isCharsEquals("mama", "amma");
        assertThat(result, is(true));
    }
}