package ru.job4j3.collectionspro.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleSetTest to test class SimpleSet.
 * @author vivanov
 * @version 1
 * @since 26.06.2018
 */
public class SimpleSetTest {

    /** Field insatance of SimpleSet.*/
    private SimpleSet<String> set = new SimpleSet<>();

    /** Field iterator.*/
    private Iterator itr = set.iterator();

    /**
     * Initialization block.
     */
    @Before
    public void setUp() {
        set.add("one");
        set.add("two");
    }

    /**
     * Method to check iterator.
     */
    @Test
    public void checkIterator() {
        assertThat(itr.next(), is("one"));
        assertThat(itr.next(), is("two"));
    }

    /**
     * Method to check iterator and method add.
     */
    @Test
    public void checkIfAddDuplicate() {
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("one"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("two"));
        this.set.add("two");
        assertThat(itr.hasNext(), is(false));
        this.set.add("free");
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("free"));
    }
}