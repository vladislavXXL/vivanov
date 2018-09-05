package ru.job4j3.collectionspro.tree;

import java.util.Optional;

/**
 * Interface SimpleTree.
 * @author vivanov
 * @version 1
 * @since 02.09.2018
 * @param <E> type parameter
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add child element to the root element.
     * @param parent - root element
     * @param child - child element
     * @return result true or false
     */
    boolean add(E parent, E child);

    /**
     * Find node by value.
     * @param value - node value
     * @return result node
     */
    Optional<Node<E>> findBy(E value);
}
