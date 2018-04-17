package ru.job4j3.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter of iterators.
 * @author vivanov
 * @version 1
 * @since 05.04.2018
 */
public class Converter {
    /**
     * Method to convert Iterator<Iterator<Integer>>> to Iterator<Integer>.
     * @param it - iterator
     * @return result Iterator<Integer>
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private final Iterator<Iterator<Integer>> iteratorOfIterator = it;
            private Iterator<Integer> currentIterator = null;


            @Override
            public boolean hasNext() {
                while (currentIterator == null || !currentIterator.hasNext()) {
                    if (!iteratorOfIterator.hasNext()) {
                        return false;
                    }
                    currentIterator = iteratorOfIterator.next();
                }
                return true;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();            }
        };
    }
}