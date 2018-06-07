package ru.job4j3.collectionspro.list;

/**
 * Class SimpleArrayList.
 * @author vivanov
 * @version 1
 * @since 26.05.2018
 * @param <E> type parameter
 */
public class SimpleArrayList<E> {

    /** Field size.*/
    private int size;

    /** First element.*/
    private Node<E> first;

    /**
     * Method to add new date into the first position of a data list.
     * @param date new date
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method to delete first element in the data list.
     * @return deleted element value
     */
    public E delete() {
        return delete(0);
    }

    /**
     * Method to delete element by index.
     * @param index index of element
     * @return deleted element value
     */
    public E delete(int index) {
        Node<E> result = this.first;
        E elDel = null;
        if (index > 0) {
            for (int i = 1; i < index - 1; i++) {
                result = result.next;
                if (index == 0) {
                    result = this.first;
                }
            }
            elDel = result.next.date;
            result.next = result.next.next;
        } else {
            elDel = result.date;
            this.first = result.next;
        }
        this.size--;
        return elDel;
    }

    /**
     * Method to get element value by index.
     * @param index index of an element
     * @return element
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Method to get collection size.
     * @return collection size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Class Node is used for data store.
     * @param <E> type parametr
     * @author vivanov
     * @version 1
     * @since 26.05.2018
     */
    private static class Node<E> {
        /** Some data in E type parameter type.*/
        private E date;

        /** Next element for current element.*/
        private Node<E> next;

        /**
         * Class Node constructor.
         * @param date current element data value
         */
        Node(E date) {
            this.date = date;
        }
    }
}