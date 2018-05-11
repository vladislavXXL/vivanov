package ru.job4j3.collectionspro.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray.
 * @param <T> type of generic
 * @author vivanov
 * @version 1
 * @since 23.04.2018
 */
public class SimpleArray<T extends Number> implements Iterable<T> {

    /** Array field.*/
    private Object[] t;

    /** Array index field.*/
    private int index = 0;

    /**
     * Constructor of class SimpleArray.
     * @param size of array
     */
    public SimpleArray(int size) {
        this.t =  new Object[size];
    }

    /**
     * Method to add new element to container.
     * @param model element to add
     */
    public void add(T model) {
        try {
            this.t[this.index++] = model;
        } catch (ArrayIndexOutOfBoundsException iob) {
            throw new ArrayIndexOutOfBoundsException("Container is overloaded");
        }
    }

    /**
     * Method to set new value of container element.
     * @param index element index
     * @param model element new value
     */
    public void set(int index, T model) {
        this.t[index] = model;
    }

    /**
     * Method to delete some element from container.
     * @param index index of element to delete
     */
    public void delete(int index) {
        this.t[index] = null;
    }

    /**
     * Method to get element from container.
     * @param index element index
     * @return element of type T
     */
    public T get(int index) {
        return (T) this.t[index];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    /**
     * Class SimpleArrayIterator.
     * @param <T> type generic parameter
     */
    private class SimpleArrayIterator<T> implements Iterator<T> {
        /** Index of iterator field.*/
        private int indexIterator = 0;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
            if (this.indexIterator <= t.length - 1 && t.length  > 0) {
                result = true;
            } else {
                result = false;
            }
            return result;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() throws NoSuchElementException {
            if (hasNext()) {
                return (T) t[this.indexIterator++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
