package ru.job4j3.collectionspro.list;

/**
 * Class SimpleQueueOnStack based on two stacks.
 * @param <T> - type parameter.
 * @author v.ivanov
 * @version 1
 * @since 19.09.2018
 */
public class SimpleQueueOnStack<T> {

    /** Field first stack.*/
    private SimpleArrayList<T> stack1 = new SimpleArrayList<>();

    /** Field second stack.*/
    private SimpleArrayList<T> stack2 = new SimpleArrayList<>();

    /**
     * Method poll used to get element and delete it from queue.
     * @return element
     */
    public T poll() {
        if (this.stack1.getSize() != 0) {
            while (this.stack1.getSize() != 0) {
                this.stack2.add(this.stack1.delete(0));
            }
        }
        return this.stack2.delete(0);
    }

    /**
     * Method push used to insert element into queue.
     * @param value element to insert into queue
     */
    public void push(T value) {
        this.stack1.add(value);
    }
}
