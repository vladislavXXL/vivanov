package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test DynamicArray container.
 * @author vivanov
 * @version 1
 * @since 04.06.2018
 */
public class DynamicArrayTest {

    /** Field DynamicArray container.*/
    private DynamicArray<String> box;

    /** Container common iterator.*/
    private Iterator<String> itrSimple;

    /** Container iterator to check ConcurrentModificationException.*/
    private Iterator<String> itrExcept;

    /**
     * Method to initialize container.
     */
    @Before
    public void setUp() {
        box = new DynamicArray<String>();
        itrSimple = box.iterator();
        box.add("zero");
        box.add("one");
        box.add("two");
        box.add("free");
        box.add("for");
    }

    /**
     * Method to check add and get.
     */
    @Test
    public void addAndGet() {
        assertThat(box.get(2), is("two"));
        assertThat(box.get(4), is("for"));
    }

    /**
     * Method to check contains.
     */
    @Test
    public void checkContains() {
        assertThat(box.contains("two"), is(true));
    }

    /**
     * Method to check iterator.
     */
    @Test
    public void checkIterator() {
        assertThat(itrSimple.hasNext(), is(true));
        assertThat(itrSimple.next(), is("zero"));
        assertThat(itrSimple.hasNext(), is(true));
        assertThat(itrSimple.next(), is("one"));
        assertThat(itrSimple.hasNext(), is(true));
        assertThat(itrSimple.next(), is("two"));
        assertThat(itrSimple.hasNext(), is(true));
        assertThat(itrSimple.next(), is("free"));
        assertThat(itrSimple.hasNext(), is(true));
        assertThat(itrSimple.next(), is("for"));
        assertThat(itrSimple.hasNext(), is(false));
    }

    /**
     * Method to check ConcurrentModificationException if container structure was modified.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void checkConcurrentModificationException() {
        itrExcept = box.iterator();
        box.add("five");
        box.add("six");
        assertThat(itrExcept.hasNext(), is(true));
        assertThat(itrExcept.next(), is("five"));
    }
}