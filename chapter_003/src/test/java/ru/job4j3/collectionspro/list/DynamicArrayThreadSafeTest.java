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
     * Test method add() and get().
     */
    @Test
    public void testAddAndGet() {
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



}