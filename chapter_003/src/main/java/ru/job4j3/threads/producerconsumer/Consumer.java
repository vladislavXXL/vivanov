package ru.job4j3.threads.producerconsumer;

import java.util.stream.IntStream;

/**
 * Class Consumer.
 *
 * @author v.ivanov
 * @version 1
 * @since 28.04.2019
 */
public class Consumer implements Runnable {
    /** Field instance Q.*/
    private Q q;

    /**
     * Consumer constructor.
     * @param q Q instance
     */
    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
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
        IntStream.range(0, 5).forEach(i -> this.q.get());
    }
}
