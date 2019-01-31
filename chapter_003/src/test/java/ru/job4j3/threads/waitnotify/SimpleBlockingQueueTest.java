package ru.job4j3.threads.waitnotify;

import org.junit.Test;

/**
 * Class SimpleBlockingQueueTest.
 * @author v.ivanov
 * @version 1
 * @since 21.01.2019
 */
public class SimpleBlockingQueueTest {

    /**
     * Test to check ProductConsumer pattern.
     */
    @Test
    public void test() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 101; i++) {
                queue.offer(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 101; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
