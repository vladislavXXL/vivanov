package ru.job4j3.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenNumbersIterator to return only even numbers.
 * @author vivanov
 * @version 1
 * @since 01.04.2018
 */
public class EvenNumbersIterator implements Iterable {
    /** Field array.*/
    private int[] values;

    /**
     * Class EvenNumbersIterator constructor.
     * @param array iterable array.
     */
    public EvenNumbersIterator(int[] array) {
        this.values = array;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new EvenNumbersIteratorRealise(this.values);
    }

    /**
     * Class EvenNumbersIteratorRealise to implement Iterator.
     */
    private class EvenNumbersIteratorRealise implements Iterator {
        /** Field array.*/
        private int[] array;

        /** Field i - element index.*/
        private int i = 0;

        /**
         * Class EvenNumbersIteratorRealise constructor.
         * @param array itarable array
         */
        EvenNumbersIteratorRealise(int[] array) {
            this.array = array;
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
            boolean result = false;
            if (this.array.length > 0) {
                for (int j = i; j < this.array.length; j++) {
                    if (this.array[j] % 2 == 0) {
                        i = j;
                        result = true;
                        break;
                    }
                }
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
        public Integer next() throws NoSuchElementException {
            if (hasNext()) {
                return this.array[i++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}