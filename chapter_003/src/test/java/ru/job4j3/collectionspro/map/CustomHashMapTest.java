package ru.job4j3.collectionspro.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * To test class CustomHashMap.
 * @author v.ivanov
 * @version 1
 * @since 26.08.2018
 */
public class CustomHashMapTest {

    /** Field some custom map.*/
    private CustomHashMap<String, String> map;

    /** Field iterator.*/
    private Iterator<String> itr;

    /**
     * Initialization block.
     */
    @Before
    public void setUp() {
        /** Field some custom map.*/
        this.map = new CustomHashMap<>();
        this.itr = map.iterator();

        this.map.insert("1", "value1");
        this.map.insert("2", "value2");
        this.map.insert("3", "value3");
        this.map.insert("4", "value4");
        this.map.insert("5", "value5");
        this.map.insert("6", "value6");
    }

    /**
     * Method to test insert and get.
     */
    @Test
    public void whenInsertThenGet() {
        assertThat(this.map.get("1"), is("value1"));
        assertThat(this.map.get("2"), is("value2"));
        assertThat(this.map.get("3"), is("value3"));
    }

    /**
     * Method to test getting size of the map.
     */
    @Test
    public void whenGetSizeThenSize() {
        assertThat(this.map.getSize(), is(6));
    }

    /**
     * Method to test hasNext() and next().
     */
    @Test
    public void whenHasNextAndNext() {
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(true));
        itr.next();
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Method to test delete().
     */
    @Test
    public void whenDeleteThenTrue() {
        assertThat(this.map.delete("2"), is(true));
        assertThat(this.map.get("2"), nullValue());
    }

    /**
     * Method to test mapResize().
     */
    @Test
    public void whenMapResize() {
        this.map.insert("7", "value7");
        this.map.insert("8", "value8");
        assertThat(this.map.getSize(), is(8));
    }
}
