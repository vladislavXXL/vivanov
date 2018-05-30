package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test SimpleArrayList.
 * @author vivanov
 * @version 1
 * @since 28.05.2018
 */
public class SimpleArrayListTest {

    /** Field SimpleArrayList to store data list.*/
    private SimpleArrayList<String> obj;


    /**
     * Method to setup new SimpleArrayList object.
     */
    @Before
    public void setUp() {
        obj = new SimpleArrayList<>();
        obj.add("line1");
        obj.add("line2");
        obj.add("line3");
        obj.add("line4");
    }

    /**
     * Method to check Add and Get methods.
     */
    @Test
    public void checkAddAndGet() {
        assertThat("line4", is(obj.get(0)));
        assertThat("line1", is(obj.get(3)));
    }

    /**
     * Method to check getSize of list.
     */
    @Test
    public void checkGetSizeList() {
        assertThat(4, is(obj.getSize()));
    }

    /**
     * Method to check delete first element from list.
     */
    @Test
    public void checkDelete() {
        obj.delete();
        assertThat("line3", is(obj.get(0)));
    }

    /**
     * Method to check delete by index.
     */
    @Test
    public void checkDeleteByIndex() {
        String result = obj.delete(1);
        assertThat(result, is("line3"));
        String newEl = obj.get(1);
        assertThat(newEl, is("line2"));

    }
}