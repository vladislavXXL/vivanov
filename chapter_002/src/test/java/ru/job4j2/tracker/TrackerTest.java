package ru.job4j2.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.core.IsNull.nullValue;


/**
 * Class TrackerTest.
 * @author vivnanov
 * @version 1
 * @since 01.06.2017
 */
public class TrackerTest {

    /**
     * Test add new item method.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("0", "test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * Test update item method.
     */
    @Test
    public void whenUpdateItemThenNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("0", "test1", "testDescription", 1L);
        tracker.add(item);
        Item itemToChange = new Item("0", "newTest1", "newTestDescription", 2L);
        tracker.update(itemToChange);
        assertThat(tracker.getAll()[0], is(itemToChange));
    }

    /**
     * Test delete item method.
     */
    @Test
    public void whenDeleteItemThenEmpty() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("0", "test1", "testDescription", 1L);
        tracker.add(item1);
        Item item2 = new Item("1", "test2", "testDescription2", 2L);
        tracker.add(item2);
        tracker.delete(item1);
        assertThat(tracker.getAll()[0], is(item2));
    }

    /**
     * Test findAll method.
     */
    @Test
    public void whenFindAllThenReturnItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("0", "test1", "testDescription", 1L);
        tracker.add(item1);
        Item item2 = new Item("1", "test2", "testDescription2", 2L);
        tracker.add(item2);
        Item item3 = new Item("3", "test3", "testDescription3", 3L);
        tracker.add(item3);
        tracker.delete(item2);
        Item[] result = {item1, item3};
        assertThat(tracker.findAll(), is(result));
    }

    /**
     * Test findByName method.
     */
    @Test
    public void whenFindByNameThenReturnItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("0", "test1", "testDesc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("1", "test2", "testDesc2", 124L);
        tracker.add(item2);
        Item item3 = new Item("2", "test3", "testDesc3", 125L);
        tracker.add(item3);
        assertThat(tracker.findByName("test1"), is(item1));
    }


    /**
     * Test findById method.
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("0", "test1", "testDesc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("1", "test2", "testDesc2", 124L);
        tracker.add(item2);
        Item item3 = new Item("2", "test3", "testDesc3", 125L);
        tracker.add(item3);
        assertThat(tracker.findById("2"), is(item3));
    }
}