package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test ContainerLinked.
 * @author vivanov
 * @version 1
 * @since 14.06.2018
 */
public class ContainerLinkedTest {

    /** Field ContainerLinked to store linked list of objects.*/
    private ContainerLinked<String> obj;

    /** Field iterator.*/
    private Iterator itr;

    /** Container iterator to check ConcurrentModificationException.*/
    private Iterator itrExcept;

    /**
     * Setup before tests begins.
     */
    @Before
    public void setUp() {
        obj = new ContainerLinked<>();
        obj.add("value1");
        obj.add("value2");
        itr = obj.iterator();
    }

    /**
     * Method to check add operation and iterator.
     */
    @Test
    public void checkAddElementAndIterator() {
        assertThat(true, is(itr.hasNext()));
        assertThat("value1", is(itr.next()));
        assertThat(true, is(itr.hasNext()));
        assertThat("value2", is(itr.next()));
        assertThat(false, is(itr.hasNext()));
    }

    /**
     * Method to check get operation.
     */
    @Test
    public void checkGetElementByIndex() {
        assertThat(obj.get(0), is("value1"));
        assertThat(obj.get(1), is("value2"));
    }

    /**
     * Method to check contains operation.
     */
    @Test
    public void checkContains() {
        assertThat(obj.contains("value2"), is(true));
        assertThat(obj.contains("value99"), is(false));
    }

    /**
     * Method to check delete by index.
     */
    @Test
    public void checkDeleteByIndex() {
        assertThat(obj.delete(0), is("value1"));
        assertThat(obj.get(0), is("value2"));
    }

    /**
     * Method to check ConcurrentModificationException if container structure was modified.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void checkConcurrentModificationException() {
        itrExcept = obj.iterator();
        obj.add("value3");
        assertThat(itrExcept.hasNext(), is(true));
        assertThat(itrExcept.next(), is("value3"));
    }
}