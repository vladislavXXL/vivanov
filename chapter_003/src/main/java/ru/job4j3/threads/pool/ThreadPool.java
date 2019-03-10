package ru.job4j3.threads.pool;

import ru.job4j3.threads.waitnotify.SimpleBlockingQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ThreadPool.
 *
 * @author v.ivanov
 * @version 1
 * @since 08.03.2019
 */
public class ThreadPool {

    /** Field size of the pool.*/
    private final int size = Runtime.getRuntime().availableProcessors();

    /** Field threads list.*/
    private final List<Thread> threads = new ArrayList<>();

    /** Field tasks.*/
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<Runnable>(10);

    /**
     * Constructor of the ThreadPool class.
     */
    public ThreadPool() {
        for (int i = 0; i < this.size; i++) {
            threads.add(new Thread(() -> {
                try {
                    this.tasks.poll().run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }));
        }
        for (Thread thread: threads) {
            thread.start();
        }
    }

    /**
     * Method work used to add tasks to the queue.
     *
     * @param job some task
     */
    public void work(Runnable job) {
        this.tasks.offer(job);
    }

    /**
     * Method used to terminate all the threads.
     */
    public void shutdown() {
        for (Thread thread: this.threads) {
            thread.interrupt();
        }
    }

    /**
     * Method to check if tasks is finished.
     *
     * @return result true or false
     */
    public boolean isEmpty() {
        return this.tasks.isEmpty();
    }
}
