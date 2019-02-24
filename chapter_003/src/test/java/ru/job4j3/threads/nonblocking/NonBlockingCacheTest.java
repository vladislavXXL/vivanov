package ru.job4j3.threads.nonblocking;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for NonBlockingCache class.
 *
 * @author v.ivanov
 * @version 1
 * @since 24.02.2019
 */
public class NonBlockingCacheTest {

    /** Field NonBlockingCache instance.*/
    private NonBlockingCache cache;

    /**
     * Method to initialize field cache.
     */
    @Before
    public void setUp() {
        this.cache = new NonBlockingCache();
        this.cache.add(new Base(1, "Model_1"));
        this.cache.add(new Base(2, "Model_2"));
        this.cache.add(new Base(3, "Model_3"));
        this.cache.add(new Base(4, "Model_4"));
    }

    /**
     * Method to check add operation.
     */
    @Test
    public void whenAddOperation() {
        assertThat(this.cache.getStore().get(1).getVersion(), is(0));
    }

    /**
     * Method to check update operation.
     */
    @Test
    public void whenUpdateOperation() {
        this.cache.update(new Base(1, "Model_1v2"));
        assertThat(this.cache.getStore().get(1).getVersion(), is(1));
        assertThat(this.cache.getStore().get(1).getName(), is("Model_1v2"));
    }

    /**
     * Method to check exception throws.
     * @throws InterruptedException exception
     */
    @Test()
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread1 = new Thread(() -> {
            try {
                this.cache.update(new Base(2, "Model_2v2"));
            } catch (Exception e) {
                ex.set(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                this.cache.update(new Base(2, "Model_2v2"));
            } catch (Exception e) {
                ex.set(e);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(ex.get().getMessage(), is("Data has been changed while working process!"));
    }
}