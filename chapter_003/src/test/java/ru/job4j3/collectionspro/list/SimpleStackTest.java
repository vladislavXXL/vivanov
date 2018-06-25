package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleStackTest to test SimpleStack implements Stack container.
 * @author vivanov
 * @version 1
 * @since 20.06.2018
 */
public class SimpleStackTest {

    /** Field SimpleStack container.*/
    private SimpleStack<String> cnt = new SimpleStack<>();

    /**
     * Create and initialize Stack Container.
     */
    @Before
    public void setUp() {
        this.cnt.push("Value1");
        this.cnt.push("Value2");
        this.cnt.push("Value3");
        this.cnt.push("Value4");
    }

    /**
     * Method to check push() and poll().
     */
    @Test
    public void checkPushAndPoll() {
        assertThat(this.cnt.poll(), is("Value4"));
        assertThat(this.cnt.poll(), is("Value3"));
    }
}