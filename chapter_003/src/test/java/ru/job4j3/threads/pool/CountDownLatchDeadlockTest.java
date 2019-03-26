package ru.job4j3.threads.pool;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Class DeadLockCountDownLatchTest.
 * @author v.ivanov
 * @version 1
 * @since 24.03.2019
 */
public class CountDownLatchDeadlockTest {

    /**
     * Method to test DeadLock realised by CountDownLatch.
     */
    @Test
    public void testRunDeadLock() {
        CountDownLatch latch = new CountDownLatch(2);
        CountDownLatchDeadlock obj = new CountDownLatchDeadlock(latch);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.inc();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.dec();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}