package ru.job4j2.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
//import static org.hamcrest.Matchers.contains;


/**
 * Class StubInputTest to test StubInput class.
 */
public class StubInputTest {

    /**
     * Method to test adding operation to tracker.
     */
    @Test
    public void whenAddNewItem() {
            StubInput input = new StubInput(new String[]{"0", "1", "name1", "desc1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("name1"));
    }

    /**
     * Method to test show operation.
     */
    @Test
    public void whenShowItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "name1", "desc1", 123L));
        tracker.add(new Item("2", "name2", "desc2", 124L));
        StubInput input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
    }

    /**
     * Method to test update operation.
     */
    @Test
    public void whenUpdateItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "name1", "desc1", 123L));
        StubInput input = new StubInput(new String[]{"2", "1", "nameChanged", "descChanged", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById("1").getName(), is("nameChanged"));
    }

    /**
     * Method to test delete operation.
     */
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "name1", "desc1", 123L));
        tracker.add(new Item("2", "name2", "desc2", 124L));
        tracker.add(new Item("3", "name3", "desc3", 125L));
        StubInput input = new StubInput(new String[]{"3", "2", "name2", "desc2", "6"});
        new StartUI(input, tracker).init();
        StubInput input2 = new StubInput(new String[]{"1", "6"});
        new StartUI(input2, tracker).init();
    }

    /**
     * Method to test findById operation.
     */
    @Test
    public void whenFindByIdItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "name1", "desc1", 123L));
        tracker.add(new Item("2", "name2", "desc2", 124L));
        tracker.add(new Item("3", "name3", "desc3", 125L));
        StubInput input = new StubInput(new String[]{"4", "2", "6"});
        new StartUI(input, tracker).init();
    }

    /**
     * Method to test find by name operation.
     */
    @Test
    public void whenFindByNameItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", "name1", "desc1", 123L));
        tracker.add(new Item("2", "name2", "desc2", 124L));
        tracker.add(new Item("3", "name3", "desc3", 125L));
        StubInput input = new StubInput(new String[]{"5", "name2", "6"});
        new StartUI(input, tracker).init();
    }

    /**
     * Method to test exit operation.
     */
    @Test
    public void whenExitProgram() {
        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
    }
}
