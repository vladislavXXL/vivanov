package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class DynamicArrayThreadSafeTest.
 * @author v.ivanov
 * @version 1
 * @since 16.01.2019
 */
public class DynamicArrayThreadSafeTest {

    /** Field DynamicArray container.*/
    private static DynamicArrayThreadSafe<String> box;

    /**
     * Block of initialization.
     */
    @Before
    public void setUp() {
        box = new DynamicArrayThreadSafe<>();
        box.add("zero");
        box.add("one");
        box.add("two");
        box.add("free");
    }

    /**
     * Test method add() and get().
     */
    @Test
    public void testAddAndGet() {
        assertThat(box.get(0), is("zero"));
        assertThat(box.get(3), is("free"));
    }



}