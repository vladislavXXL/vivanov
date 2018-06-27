package ru.job4j3.collectionspro.list;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Class ContainerLinked based on LinkedList.
 * @author vivanov
 * @version 1
 * @since 14.06.2018
 * @param <E> type parameter
 */
public class ContainerLinked<E> implements Iterable<E> {

    /** Field container size.*/
    private int size;

    /** First element.*/
    private Node<E> first;

    /** Last element.*/
    private Node<E> last;

    /** Container modification counter.*/
    private int modCount = 0;

    /**
     * Add new element.
     * @param value new element value
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        if (this.size == 0) {
            this.first = newLink;
        } else {
            this.last.next = newLink;
        }
        this.last = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Return element by index.
     * @param index index element to find
     * @return element value
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result = result.next;
                if (index == 0) {
                    result = this.first;
                }
                break;
            }
        }
        return result.data;
    }

    /**
     * Method to delete element by index.
     * @param index index of element to delete
     * @return deleted element value
     */
    public E delete(int index) {
        Node<E> result = this.first;
        E el = null;
        if (index < 1) {
            el = result.data;
            this.first = result.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                result = result.next;
            }
            el = result.next.data;
            result.next = result.next.next;
        }
        this.size--;
        return el;
    }

    /**
     * Used to check if container contains some value.
     * @param value to find
     * @return result true or false
     */
    public boolean contains(E value) {
        boolean result = false;
        Node<E> el = this.first;
        for (int i = 0; i < this.size; i++) {
            if (el.data.equals(value)) {
                result = true;
            }
            el = el.next;
        }
        return result;
    }

    /**
     * Class Node to store data.
     * @param <E> type parameter
     */
    private class Node<E> {
        /** Some data to store in the LinkedContainer.*/
        private E data;

        /** Next element in the LinkedContainer.*/
        private Node<E> next;

        /**
         * Node constructor.
         * @param value data value
         */
        Node(E value) {
            this.data = value;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator(this.modCount, this.first);
    }

    /**
     * Class LinkedIterator realisation of Iterator.
     * @param <E> type parameter
     */
    private class LinkedIterator<E> implements Iterator<E> {

        /** Iterator index.*/
        private int indexItr = 0;

        /** Current iterator value.*/
        private Node<E> itrElem;

        /** Saved value of the container modification operation counter.*/
        private int expectedModCount;

        /**
         * LinkedIterator constructor.
         * @param counter modification counter
         * @param firstElem first element
         */
        private LinkedIterator(int counter, Node<E> firstElem) {
            this.expectedModCount = counter;
            this.itrElem = firstElem;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return this.indexItr < size ? true : false;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         * @throws ConcurrentModificationException if the container modified
         */
        @Override
        public E next() {
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (hasNext()) {
                E result = this.itrElem.data;
                this.itrElem = this.itrElem.next;
                this.indexItr++;
                return result;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
