package ru.job4j3.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class EvenNumbersIteratorTest.
 * @author vivanov
 * @version 1
 * @since 01.04.2018
 */
public class EvenNumbersIteratorTest {

    /** Field iterator.*/
    private Iterator<Integer> it;

    /**
     * Method to setup iterator.
     */
    @Before
    public void setUp() {
        it = new EvenNumbersIterator(new int[]{1, 2, 3, 4, 5, 6, 7}).iterator();
    }

    /**
     * Method to test NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Method to test hasNext() doesn't affect next().
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    /**
     * Method to test if no any even number.
     */
    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenNumbersIterator(new int[]{1}).iterator();
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Method to test if all numbers in array are even.
     */
    @Test
    public void allNumbersAreEven() {
        it = new EvenNumbersIterator(new int[]{2, 4, 6, 8}).iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
}