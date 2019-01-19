package ru.job4j3.collectionspro.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Dynamic Array container.
 * @author vivanov
 * @version 1
 * @since 04.06.2018
 * @param <E> type parameter
 */
public class DynamicArray<E> implements Iterable<E> {

    /** Dynamic array container field.*/
    private Object[] container;

    /** Current array index.*/
    private int index = 0;

    /** Size of the container elements.*/
    private final int size = 5;

    /** Container modification counter.*/
    private int modCount = 0;

    /**
     * DynamicArray class constructor.
     */
    public DynamicArray() {
        this.container = new Object[this.size];
    }

    /**
     * Method to add new element to container.
     * @param value value of new element
     */
    public void add(E value) {
        if (this.index <= this.size - 1) {
            this.container[index++] = value;
        } else {
            this.container = Arrays.copyOf(this.container, this.size + 4);
            this.modCount++;
            this.container[index++] = value;
        }
    }

    /**
     * Method to set value by index.
     * @param index index
     * @param value of element
     * @return result of operation
     */
    public boolean set(int index, E value) {
        boolean result = false;
        if (index <= this.index) {
            this.container[index] = value;
            result = true;
        }
        return result;
    }

    /**
     * Method to check if element exist in current array.
     * @param value to check
     * @return result true or false
     */
    public boolean contains(E value) {
        boolean result = false;
        for (int i = 0; i < this.size; i++) {
            if (value.equals(this.container[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method to get element by index.
     * @param index index of array element to get
     * @return element
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorRealise(this.modCount);
    }

    /**
     * Class IteratorRealise to implement Iterator.
     */
    public class IteratorRealise implements Iterator<E> {

        /** Saved value of the container modification operation counter.*/
        private final int expectedModCount;

        /** Iterator index.*/
        private int itrIndex = 0;

        /**
         * Constructor of class IteratorRealise.
         * @param modCount current modification operation counter
         */
        public IteratorRealise(int modCount) {
            this.expectedModCount = modCount;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return this.itrIndex < index;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         * @throws ConcurrentModificationException if the container was modified
         */
        @Override
        public E next() {
            synchronized (DynamicArray.this) {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return (E) container[this.itrIndex++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        }
    }
}