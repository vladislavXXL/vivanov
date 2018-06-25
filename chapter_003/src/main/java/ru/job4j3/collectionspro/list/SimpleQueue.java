package ru.job4j3.collectionspro.list;

/**
 * Class SimpleQueue implements Queue (FIFO).
 * @param <T> type parameter
 * @author vivanov
 * @version 1
 * @since 18.06.2018
 */
public class SimpleQueue<T> {

    /** Field ContainerLinked container queue.*/
    private ContainerLinked<T> queue = new ContainerLinked();

    /**
     * Method poll returns value in queue order.
     * @return returns first added value
     */
    public T poll() {
        return this.queue.delete(0);
    }

    /**
     * Method push for Queue.
     * @param value value to push
     */
    public void push(T value) {
        this.queue.add(value);
    }
}