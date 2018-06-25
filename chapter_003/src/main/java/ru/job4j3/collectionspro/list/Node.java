package ru.job4j3.collectionspro.list;

/**
 * Class Node with cycle check.
 * @author vivanov
 * @version 1
 * @since 24.06.2018
 * @param <T> type parameter
 */
public class Node<T> {

    /** Field value.*/
    private T value;

    /** Field next element.*/
    private Node<T> next;

    /**
     * Class Node constructor without parameters.
     */
    public Node() {

    }

    /**
     * Class Node constructor with parameter value.
     * @param value value
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Next element setter.
     * @param next value of next element
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Method to check if some list has cycle inside.
     * @param first first element of a list
     * @return result true if cycle exist, else false
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        Node st = first;
        Node nd = first;
        while (!result && nd.next != null && nd.next.next != null) {
            st = st.next;
            nd = nd.next.next;
            if (st != null && nd == st) {
                result = true;
                break;
            }
        }
        return result;
    }
}