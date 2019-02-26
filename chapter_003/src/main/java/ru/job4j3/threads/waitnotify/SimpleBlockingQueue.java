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
    private final Queue<T> queue = new LinkedList<>();

    /** Field queue capacity.*/
    private final int capacity;

    /**
     * SimpleBlockingQueue constructor.
     * @param capacity size of queue
     */
    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Method to get queue capacity.
     * @return result size
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Method to check if queue is empty.
     * @return result true or false
     */
    public boolean isEmpty() {
        return this.queue.size() == 0;
    }

    /**
     * Method offer() to put into queue.
     * @param value value to put into queue
     */
    public synchronized void offer(T value) {
        this.queue.offer(value);
        System.out.printf("Added value: %s. Size is: %d\n", value.toString(), this.queue.size());
        this.notify();
        while (this.queue.size() > this.capacity - 1) {
            System.out.printf("Queue is full!\n");
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    /**
     * Method poll() to get from queue and delete.
     * @return result of operation
     * @throws InterruptedException exception
     */
    public synchronized T poll() throws InterruptedException {
        System.out.printf("Inside poll!\n");
        while (this.queue.isEmpty()) {
            this.wait();
        }
        T result = this.queue.poll();
        System.out.printf("Deleted value is: %s. Size is: %d\n", result.toString(), this.queue.size());
        this.notify();
        return result;
    }
}
