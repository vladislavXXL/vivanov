package ru.job4j3.collectionspro.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class SimpleArrayTest.
 * @author vivanov
 * @version 1
 * @since 23.04.2018
 */
public class SimpleArrayTest {

    /** Field container.*/
    private SimpleArray<Float> simple;

    /** Field iterator.*/
    private Iterator<Float> it;

    /**
     * Setup container and iterator.
     */
    @Before
    public void setUp() {
        simple = new SimpleArray<Float>(2);
        simple.add(1f);
        simple.add(77f);
        it = simple.iterator();
    }

    /**
     * Test to check iterator.
     */
    @Test
    public void whenCalledIterator() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1f));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(77f));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test to check get and set values of container.
     */
    @Test
    public void whenCalledGetAndSet() {
        assertThat(simple.get(1), is(77f));
        simple.set(1, 55f);
        assertThat(simple.get(1), is(55f));
    }

    /**
     * Test to check element delete.
     */
    @Test
    public void whenCalledDelete() {
        simple.delete(1);
        assertThat(simple.get(1), is(nullValue()));
    }

    /**
     * Test to check NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCalledException() {
        it.next();
        it.next();
        it.next();
    }
}