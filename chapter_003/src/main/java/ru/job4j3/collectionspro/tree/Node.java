package ru.job4j3.collectionspro.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node.
 * @author vivanov
 * @version 1
 * @since 02.09.2018
 * @param <E>
 */
public class Node<E extends Comparable<E>> {

    /** Field list of children nodes.*/
    private final List<Node<E>> children = new ArrayList<>();

    /** Field Node value.*/
    private final E value;

    /**
     * Class Node constructor.
     * @param value - value
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Value getter.
     * @return result E value
     */
    public E getValue() {
        return this.value;
    }

    /**
     * Method to add new child.
     * @param child - child node
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Method get all leaves.
     * @return list of nodes
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Method eqValue to check identity.
     * @param that - parameter to check
     * @return result true or false
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }


}
