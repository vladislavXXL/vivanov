package ru.job4j3.threads.pool;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Class to check LatchDeadLock.
 * @author v.ivanov
 * @version 1
 * @since 07.04.2019
 */
public class LatchDeadLockTest {

    /**
     * Test to run deadlock.
     */
    @Ignore
    @Test
    public void checkDeadLock() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(new LatchDeadLock(obj1, obj2, latch));
        Thread t2 = new Thread(new LatchDeadLock(obj2, obj1, latch));
        Thread threadCheckLock = new Thread(new ThreadDeadlockFinder());
        t1.setDaemon(true);
        t2.setDaemon(true);
        threadCheckLock.setDaemon(true);
        t1.start();
        t2.start();
        threadCheckLock.start();
        try {
            t1.join();
            t2.join();
            threadCheckLock.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
