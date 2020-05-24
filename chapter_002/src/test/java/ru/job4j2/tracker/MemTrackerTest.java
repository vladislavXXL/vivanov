package ru.job4j2.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.core.IsNull.nullValue;


/**
 * Class TrackerTest.
 * @author vivnanov
 * @version 1
 * @since 01.06.2017
 */
public class MemTrackerTest {

    /**
     * Test add new item method.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("0", "test1", "testDescription", 123L);
        memTracker.add(item);
        Item item2 = new Item("0", "test1", "testDescription", 123L);
        memTracker.add(item2);
        assertThat(memTracker.getAll().get(1), is(item2));
    }

    /**
     * Test update item method.
     */
    @Test
    public void whenUpdateItemThenNewItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("0", "test1", "testDescription", 1L);
        memTracker.add(item);
        Item itemToChange = new Item("0", "newTest1", "newTestDescription", 2L);
        memTracker.update(itemToChange);
        assertThat(memTracker.getAll().get(0), is(itemToChange));
    }

    /**
     * Test delete item method.
     */
    @Test
    public void whenDeleteItemThenEmpty() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("0", "test1", "testDescription", 1L);
        memTracker.add(item1);
        Item item2 = new Item("1", "test2", "testDescription2", 2L);
        memTracker.add(item2);
        memTracker.delete(item1);
        assertThat(memTracker.getAll().get(0), is(item2));
    }

    /**
     * Test findAll method.
     */
    @Test
    public void whenFindAllThenReturnItems() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("0", "test1", "testDescription", 1L);
        memTracker.add(item1);
        Item item2 = new Item("1", "test2", "testDescription2", 2L);
        memTracker.add(item2);
        Item item3 = new Item("3", "test3", "testDescription3", 3L);
        memTracker.add(item3);
        memTracker.delete(item2);
        List<Item> result = Arrays.asList(item1, item3);
        assertThat(memTracker.getAll(), is(result));
    }

    /**
     * Test findById method.
     */
    @Test
    public void whenFindById() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("0", "test1", "testDesc1", 123L);
        memTracker.add(item1);
        Item item2 = new Item("1", "test2", "testDesc2", 124L);
        memTracker.add(item2);
        Item item3 = new Item("2", "test3", "testDesc3", 125L);
        memTracker.add(item3);
        assertThat(memTracker.findById("2"), is(item3));
    }

    /**
     * Test findByName method.
     */
    @Test
    public void whenFindByNameThenReturnItems() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("0", "name", "testDesc1", 123L);
        memTracker.add(item1);
        Item item2 = new Item("1", "name", "testDesc2", 124L);
        memTracker.add(item2);
        Item item3 = new Item("2", "methodName", "testDesc3", 125L);
        memTracker.add(item3);
        List<Item> result = Arrays.asList(item1, item2);
        assertThat(memTracker.findByName("name"), is(result));
    }
}