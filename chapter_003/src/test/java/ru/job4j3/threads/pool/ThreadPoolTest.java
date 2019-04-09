package ru.job4j3.threads.pool;

import org.junit.Test;

/**
 * Class ThreadPoolTest to test class ThreadPool.
 * @author v.ivanov
 * @version 1
 * @since 10.03.2019
 */
public class ThreadPoolTest {

    /** Field pool.*/
    private ThreadPool pool;

    /**
     * Initialization block.
     */
    @Test
    public void setUp() {
        this.pool = new ThreadPool();
        this.pool.work(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.format("Job Block #1. Task %d\n", i);
            }
        });

        this.pool.work(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.format("Job Block #2. Task %d\n", i);
            }
        });
    }

    /**
     * Method to check if tasks in pool are finished.
     */
/*
    @Test
    public void whenPoolJobsComplete() {
        this.pool.shutdown();
        assertTrue("Condition is false. Pool tasks not empty", this.pool.isEmpty());
    }
*/
}
