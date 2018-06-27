package ru.job4j3.collectionspro.set;

import ru.job4j3.collectionspro.list.ContainerLinked;

import java.util.Iterator;

/**
 * @author vivanov
 * @version 1
 * @since 27.06.2018
 * @param <T> type parameter
 */
public class SimpleSetLinked<T> implements Iterable<T> {

    /**Field set based on class ContainerLinked.*/
    private ContainerLinked<T> set = new ContainerLinked<>();

    /**
     * Method to add new unique element to the set.
     * @param e new element
     */
    public void add(T e) {
        if (!this.set.contains(e)) {
            this.set.add(e);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return this.set.iterator();
    }
}
