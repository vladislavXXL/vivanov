package ru.job4j3.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIterator.
 * @author vivanov
 * @version 1
 * @since  25.03.2018
 */
public class MatrixIterator implements Iterable {

    /** array field.*/
    private int[][] values;

    /**
     * Constructor.
     * @param values array
     */
    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new IteratorRealise(this.values);
    }

    /**
     * Class IteratorRealise.
     */
    public class IteratorRealise implements Iterator {

        /** Array field.*/
        private int[][] valuesItr;

        /** Array index i.*/
        private int i = 0;

        /** Array index j.*/
        private int j = 0;

        /**
         * Class IteratorRealise constructor.
         * @param values array
         */
        public IteratorRealise(int[][] values) {
            this.valuesItr = values;
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
            if (this.valuesItr.length > 0 && j == this.valuesItr[i].length) {
                j = 0;
                i++;
            }
            return this.valuesItr.length > i && this.valuesItr[i].length > j && this.valuesItr.length > 0;
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
                return this.valuesItr[i][j++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
