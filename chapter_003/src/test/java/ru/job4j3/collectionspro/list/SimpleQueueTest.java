package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleQueueTest to test SimpleQueue.
 * @author vivanov
 * @version 1
 * @since 20.06.2018
 */
public class SimpleQueueTest {

    /** Field SimpleQueue queue container.*/
    private SimpleQueue<String> queue;

    /**
     * Method to create and initialize SimpleQueue queue container.
     */
    @Before
    public void setUp() {
        queue = new SimpleQueue<>();
        queue.push("Value1");
        queue.push("Value2");
        queue.push("Value3");
        queue.push("Value4");
        queue.push("Value5");
    }

    /**
     * Method to check push() and poll().
     */
    @Test
    public void checkPushAndPoll() {
        assertThat(queue.poll(), is("Value1"));
        assertThat(queue.poll(), is("Value2"));
        assertThat(queue.poll(), is("Value3"));
    }
}