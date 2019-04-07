package ru.job4j3.threads.pool;

import java.util.concurrent.CountDownLatch;

/**
 * Class LatchDeadLock.
 * @author v.ivanov
 * @version 1
 * @since 07.04.2019
 */
public class LatchDeadLock implements Runnable {

    /** Field latch.*/
    private CountDownLatch latch;

    /** Field first object.*/
    private Object obj1;

    /** Field second object.*/
    private Object obj2;

    /**
     * LatchDeadLock class constructor.
     * @param obj1 first object
     * @param obj2 second object
     * @param latch CountDownLatch instance
     */
    public LatchDeadLock(Object obj1, Object obj2, CountDownLatch latch) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.latch = latch;
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
        synchronized (this.obj1) {
            this.latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.obj2) {
                System.out.println("Do some operations...");
            }
        }
    }
}
