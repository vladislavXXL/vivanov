package ru.job4j3.threads.pool;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Class DeadLock with CountDownLatchTest.
 * @author v.ivanov
 * @version 1
 * @since 24.03.2019
 */

public class CountDownLatchDeadlockTest {

    @Test
    public void testRunDeadLock() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(new CountDownLatchDeadlock(obj1, obj2, latch)).start();
        new Thread(new CountDownLatchDeadlock(obj2, obj1, latch)).start();
    }

}