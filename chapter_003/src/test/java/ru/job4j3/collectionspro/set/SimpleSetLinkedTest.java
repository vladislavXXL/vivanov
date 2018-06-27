package ru.job4j3.collectionspro.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleSetLinkedTest to test class SimpleSetLinked.
 * @author vivanov
 * @version 1
 * @since 27.06.2018
 */
public class SimpleSetLinkedTest {

    /** Field set instance of class SimpleSetLinked.*/
    private SimpleSetLinked<String> set = new SimpleSetLinked<>();

    /** Field iterator.*/
    private Iterator itr;

    /**
     * Initialization block.
     */
    @Before
    public void setUp() {
        this.set.add("Value1");
        this.set.add("Value2");
        this.set.add("Value3");
        itr = this.set.iterator();
    }

    /**
     * Method to check iterator.
     */
    @Test
    public void checkIterator() {
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Value1"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Value2"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("Value3"));
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Method to check if adding a duplicates.
     */
    @Test
    public void checkIfAddDuplicates() {
        assertThat(itr.next(), is("Value1"));
        assertThat(itr.next(), is("Value2"));
        assertThat(itr.next(), is("Value3"));
        this.set.add("Value3");
        assertThat(itr.hasNext(), is(false));
    }
}