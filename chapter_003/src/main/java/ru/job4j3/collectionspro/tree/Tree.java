package ru.job4j3.collectionspro.tree;

import java.util.Optional;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

/**
 * Class Tree.
 * @param <E> - type parameter.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /** Field root.*/
    private final Node<E> root;

    /**
     * Tree constructor.
     * @param value - root element value
     */
    public Tree(E value) {
        this.root = new Node<>(value);
    }

    /**
     * Add child element to the root element.
     * @param parent - root element
     * @param child  - child element
     * @return result true or false
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = this.findBy(parent);
        boolean result = false;
        if (parentNode.isPresent() && !findBy(child).isPresent()) {
            parentNode.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    /**
     * Find node by value.
     * @param value - node value
     * @return result node
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /**
     * Class TreeIterator implements Iterator.
     */
    public class TreeIterator implements Iterator<E> {

        /** Field tree to iterate.*/
        private Queue<Node<E>> tree = new LinkedList<>();

        /**
         * TreeIterator constructor.
         */
        public TreeIterator() {
            this.tree.offer(root);
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return this.tree.size() != 0;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> someNode = this.tree.poll();
            for (Node<E> child: someNode.leaves()) {
                this.tree.offer(child);
            }
            return someNode.getValue();
        }
    }
}
