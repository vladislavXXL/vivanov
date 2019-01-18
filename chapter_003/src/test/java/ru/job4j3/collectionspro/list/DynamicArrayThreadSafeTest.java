package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class DynamicArrayThreadSafeTest.
 * @author v.ivanov
 * @version 1
 * @since 16.01.2019
 */
public class DynamicArrayThreadSafeTest {

    /** Field DynamicArray instance.*/
    private DynamicArray<String> array;

    /** Field DynamicArray container.*/
    private DynamicArrayThreadSafe<String> box;

    /**
     * Block of initialization.
     */
    @Before
    public void setUp() {
        array = new DynamicArray<>();
        array.add("zero");
        array.add("one");
        array.add("two");
        array.add("free");
        box = new DynamicArrayThreadSafe<>(array);
    }

    /**
     * Test method iterator().
     */
    @Test
    public void testIterator() {
        Iterator<String> itr = box.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("zero"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("one"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("two"));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("free"));
    }

    /**
     * Method to test get() operation.
     */
    @Test
    public void testGet() {
        assertThat(box.get(0), is("zero"));
        assertThat(box.get(3), is("free"));
    }

    /**
     * Method to test add() operation.
     */
    @Test
    public void testAdd() {
        box.add("four");
        assertThat(box.get(4), is("four"));
    }

    /**
     * Method to test set() operation.
     */
    @Test
    public void testSet() {
        assertThat(box.set(4, "five"), is(true));
        assertThat(box.get(4), is("five"));
    }
}
