package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleQueueOnStackTest to test SimpleQueueOnStack.
 * @author v.ivanov
 * @version 1
 * @since 19.09.2018
 */
public class SimpleQueueOnStackTest {

    /** Field SimpleQueueOnStack instance.*/
    private SimpleQueueOnStack<String> queue = new SimpleQueueOnStack();

    /**
     * Initialization block. Test push method.
     */
    @Before
    public void init() {
        queue.push("Line1");
        queue.push("Line2");
        queue.push("Line3");
        queue.push("Line4");
    }

    /**
     * Test queue poll method.
     */
    @Test
    public void whenQueueUsedTwoStacksPoll() {
        assertThat(queue.poll(), is("Line1"));
        assertThat(queue.poll(), is("Line2"));
        assertThat(queue.poll(), is("Line3"));
        assertThat(queue.poll(), is("Line4"));
    }
}
