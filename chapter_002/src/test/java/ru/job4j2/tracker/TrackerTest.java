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
     * Test Add new item method.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("0", "test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test Update item method.
     */
    @Test
    public void whenUpdateItemThenNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("0", "test1", "testDescription", 1L);
        tracker.add(item);
        Item itemToChange = new Item("0", "newTest1", "newTestDescription", 2L);
        tracker.update(itemToChange);
        assertThat(tracker.findAll()[0], is(itemToChange));
    }

    /**
     * Test Delete item method.
     */
    @Test
    public void whenDeleteItemThenEmpty() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("0", "test1", "testDescription", 1L);
        tracker.add(item1);
        Item item2 = new Item("1", "test2", "testDescription2", 2L);
        tracker.add(item2);
        tracker.delete(item1);
        assertThat(tracker.findAll()[0], is(item2));
    }
}