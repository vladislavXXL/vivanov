package ru.job4j3.threads.waitnotify;

/**
 * Class Producer.
 * @param <T> parametrized type parameter
 * @author v.ivanov
 * @version 1
 * @since 22.01.2019
 */
public class Producer<T extends Number> implements Runnable {

    /** Queue field.*/
    private SimpleBlockingQueue<T> queue;

    /** Thread field.*/
    private Thread thread;

    /**
     * Producer constructor.
     * @param queue queue
     */
    public Producer(SimpleBlockingQueue<T> queue) {
        this.queue = queue;
        this.thread = new Thread("Producer");
        System.out.printf("New thread %s\n", this.thread.getName());
        this.thread.start();
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
        try {
            this.queue.offer();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
