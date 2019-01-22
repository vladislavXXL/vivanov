package ru.job4j3.threads.waitnotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class SimpleBlockingQueue.
 * @version 1
 * @since 21.01.2019
 * @param <T> parametrized type parameter
 */
@ThreadSafe
public class SimpleBlockingQueue<T extends Number> {

    /** Field queue.*/
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    /** Field queue capacity.*/
    private int capacity;

    /** Field thread.*/
    private T value;

    /** Field value.*/
    private static boolean flag = false;

    /**
     * SimpleBlockingQueue constructor.
     * @param value value
     */
    public SimpleBlockingQueue(T value, int capacity) {
        this.value = value;
        this.capacity = capacity;
    }

    /**
     * Method offer().
     */
    public void offer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (!this.flag) {
                    if (this.queue.size() == this.capacity) {
                        System.out.println("Queue is full!");
                        this.flag = true;
                        notify();
                        wait();
                    }
                    System.out.printf("Value put in to the queue by Producer: %s\n", value.toString());
                    this.queue.offer(value);
                    Thread.sleep(1000);
                }
            }
        }
    }

    /**
     * Method poll().
     * @return result of operation
     */
    public T poll() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (this.flag) {
                    if (this.queue.size() == 0) {
                        System.out.println("Queue is empty!");
                        this.flag = false;
                        notify();
                        wait();
                    }
                    T result = this.queue.poll();
                    System.out.printf("Value deleted from the queue by Consumer: %s.\n\tQueue size is: %d\n", result.toString(), this.queue.size());
                    Thread.sleep(1000);
                }
            }
        }
    }
}
