package ru.job4j3.collectionspro.iterator;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class PrimeIterator.
 * @author vivanov
 * @version 1
 * @since 02.04.2018
 */
public class PrimeIterator implements Iterable {
    /** Field array.*/
    private int[] array;

    /**
     * Class PrimeIterator constructor.
     * @param array iterable array
     */
    public PrimeIterator(int[] array) {
        this.array = array;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new PrimeIteratorRealise(this.array);
    }

    /**
     * Class PrimeIteratorRealise.
     */
    private class PrimeIteratorRealise implements Iterator {
        /** Field iterable array.*/
        private int[] array;
        /** Field index.*/
        private int i;

        /**
         * Class PrimeIteratorRealise constructor.
         * @param array iterable array
         */
        PrimeIteratorRealise(int[] array) {
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
            if (this.array.length < 1) {
                return false;
            }
            for (int j = i; j < this.array.length; j++) {
                BigInteger value = BigInteger.valueOf(this.array[j]);
                if (value.isProbablePrime(this.array[j])) {
                    i = j;
                    return true;
                }
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Object next() throws NoSuchElementException {
            if (hasNext()) {
                return this.array[i++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
