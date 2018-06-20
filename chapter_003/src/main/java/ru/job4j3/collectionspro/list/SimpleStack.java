package ru.job4j3.collectionspro.list;

/**
 * Class SimpleStack implements Stack (LIFO).
 * @param <T> type parameter
 * @author vivanov
 * @version 1
 * @since 18.06.2018
 */
public class SimpleStack<T> {

    /** Field Stack container.*/
    private SimpleArrayList<T> stack;

    /**
     * SimpleStack constructor.
     */
    public SimpleStack() {
        stack = new SimpleArrayList<>();
    }

    /**
     * Method poll returns last inserted value.
     * @return returns last inserted value
     */
    public T poll() {
        return this.stack.delete();
    }

    /**
     * Method push for Stack.
     * @param value value to push
     */
    public void push(T value) {
        this.stack.add(value);
    }
}