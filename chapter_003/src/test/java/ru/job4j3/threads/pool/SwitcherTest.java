package ru.job4j3.threads.pool;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SwitcherTest to test Switcher.
 *
 * @author v.ivanov
 * @version 1
 * @since 28.04.2019
 */
public class SwitcherTest {

    /** Field Switcher instance.*/
    private Switcher switcher;

    /**
     * Initialization section.
     */
    @Before
    public void setUp() {
        this.switcher = new Switcher("String line with number ");
    }

    /**
     * Method to check Switcher addToString() method.
     */
    @Test
    public void checkSwitcherAddToStringMethod() {
        this.switcher.addToString(555);
        assertThat(this.switcher.getValue(), is("String line with number 555"));
    }

    /**
     * Method to check Switcher with two threads.
     */
    @Test
    public void checkSwitcherAddToStringWithTwoThreads() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Semaphore sem1 = new Semaphore(0);
        Semaphore sem2 = new Semaphore(1);
        final int CYCLE = 3;
        Runnable task1 = () -> {
            try {
                sem2.acquire();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            IntStream.range(0, 10).forEach(i -> this.switcher.addToString(1));
            sem1.release();
        };
        Runnable task2 = () -> {
            try {
                sem1.acquire();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            IntStream.range(0, 10).forEach(i -> this.switcher.addToString(2));
            sem2.release();
        };
        IntStream.range(0, CYCLE).forEach(i -> {
            executor.submit(task1);
            executor.submit(task2);
        });
        try {
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Termination interrupted");
        } finally {
            executor.shutdown();
        }
        assertThat(switcher.getValue(), is("String line with number 111111111122222222221111111111222222222211111111112222222222"));
    }
}
