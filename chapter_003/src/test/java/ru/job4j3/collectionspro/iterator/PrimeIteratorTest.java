package ru.job4j3.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class PrimeIteratorTest to test class PrimeIterator.
 * @author vivanov
 * @version 1
 * @since 02.04.2018
 */
public class PrimeIteratorTest {

    /** Field iterator.*/
    private Iterator<Integer> it;

    /**
     * Method to setup iterator.
     */
    @Before
    public void setUp() {
        it = new PrimeIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 3571}).iterator();
    }

    /**
     * Method to return only prime numbers.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Method to test that hasNext() doesn't affect next().
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }

    /**
     * Method to test when prime numbers are not available.
     */
    @Test
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumber() {
        it = new PrimeIterator(new int[]{4, 6}).iterator();
        assertThat("should return false, cause there is no any prime number", it.hasNext(), is(false));
    }
}
