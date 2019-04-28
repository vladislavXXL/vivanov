package ru.job4j3.threads.producerconsumer;

import org.junit.Test;

/**
 * Class ProducerConsumerTest to check Producer-Consumer pattern with Semaphore.
 * @author v.ivanov
 * @version 1
 * @since 28.04.2019
 */
public class ProducerConsumerTest {
    /**
     * Method to run ProducerConsumer.
     */
    @Test
    public void runProducerConsumer() {
        Q q = new Q();
        Thread tCons = new Thread(new Consumer(q));
        Thread tProd = new Thread(new Producer(q));
        tCons.start();
        tProd.start();
        try {
            tCons.join();
            tProd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}