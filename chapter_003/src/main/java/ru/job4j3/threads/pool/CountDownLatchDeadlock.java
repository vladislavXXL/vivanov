package ru.job4j3.threads.pool;

import java.util.concurrent.CountDownLatch;

/**
 * Class DeadLock with CountDownLatch.
 * @author v.ivanov
 * @version 1
 * @since 24.03.2019
 */
public class CountDownLatchDeadlock implements Runnable {
    /** Latch.*/
    CountDownLatch cdl;
    /** Object 1.*/
    private Object obj1;
    /** Object 2.*/
    private Object obj2;

    /** Constructor.
     *
     * @param obj1 object 1
     * @param obj2 object 2
     * @param cdl latch
     */
    public CountDownLatchDeadlock(Object obj1, Object obj2, CountDownLatch cdl) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.cdl = cdl;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (obj1) {
            cdl.countDown();
            try {
                cdl.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println("Thread finished");
            }
        }
    }
}
