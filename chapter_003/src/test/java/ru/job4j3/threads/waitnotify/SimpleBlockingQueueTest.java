package ru.job4j3.threads.waitnotify;

import org.junit.Test;

/**
 * Class SimpleBlockingQueueTest.
 * @author v.ivanov
 * @version 1
 * @since 21.01.2019
 */
public class SimpleBlockingQueueTest {

    /** First thread of the producer.*/
    private Thread t1;

    /** Second thread of the consumer.*/
    private Thread t2;

    /** Field queue.*/
    private SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(10, 3);

    /**
     * Test to check ProductConsumer pattern.
     */
    @Test
    public void test() {

        this.t1 = new Thread(new Producer<>(queue));
        this.t2 = new Thread(new Consumer<>(queue));

        this.t1.start();
        this.t2.start();

        try {
            this.t1.join();
            this.t2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
