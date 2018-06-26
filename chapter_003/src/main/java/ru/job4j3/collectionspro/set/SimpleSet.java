package ru.job4j3.collectionspro.set;

import ru.job4j3.collectionspro.list.DynamicArray;
import java.util.Iterator;

/**
 * Class SimpleSet.
 * @author vivanov
 * @version 1
 * @since 26.06.2018
 * @param <E> type parameter
 */
public class SimpleSet<E> implements Iterable<E> {

    /** Field Set based on the class DynamicArray.*/
    private DynamicArray<E> set = new DynamicArray<>();

    /**
     * Method to add new unique element.
     * @param value new element value
     */
    public void add(E value) {
        if (!this.set.contains(value)) {
            this.set.add(value);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return this.set.iterator();
    }
}