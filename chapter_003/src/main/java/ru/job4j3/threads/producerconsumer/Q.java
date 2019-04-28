package ru.job4j3.threads.producerconsumer;

import java.util.concurrent.Semaphore;

/**
 * Class Q.
 *
 * @author v.ivanov
 * @version 1
 * @since 28.04.2019
 */
public class Q {
    /** Field n.*/
    private int n;

    /** Field semCons.*/
    private static Semaphore semCons = new Semaphore(0);

    /** Field semProd.*/
    private static Semaphore semProd = new Semaphore(1);

    /**
     * Method get.
     */
    public void get() {
        try {
            semCons.acquire();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        System.out.printf("%s. Get: %d\n", Thread.currentThread().getName(), this.n);
        semProd.release();
    }

    /**
     * Method put.
     * @param value int value
     */
    public void put(int value) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        this.n = value;
        System.out.printf("%s. Put: %d\n", Thread.currentThread().getName(), this.n);
        semCons.release();
    }
}
