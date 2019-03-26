package ru.job4j3.threads.pool;

import java.util.concurrent.CountDownLatch;

/**
 * Class DeadLockCountDownLatch.
 * @author v.ivanov
 * @version 1
 * @since 24.03.2019
 */
public class CountDownLatchDeadlock {

    /** Field Latch.*/
    private CountDownLatch countDownLatch;

    /** Field some number.*/
    private int number;

    /** Constructor.
     *
     * @param countDownLatch latch
     */
    public CountDownLatchDeadlock(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    /** Method to increment field number.*/
    public void inc() {
        try {
            this.number++;
            System.out.println(this.number);
            this.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.countDownLatch.countDown();
    }

    /** Method to decrement field number.*/
    public void dec() {
        try {
            this.number--;
            System.out.println(this.number);
            this.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.countDownLatch.countDown();
    }
}
