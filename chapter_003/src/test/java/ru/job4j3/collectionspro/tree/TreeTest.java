package ru.job4j3.collectionspro.tree;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TreeSet.
 * @author vivanov
 * @version 1
 * @since 05.09.2018
 */
public class TreeTest {
    /**
     * Check add and findBy methods.
     */
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Check if value exists.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Check if duplicate is not available to add.
     * @throws Exception
     */
    @Test
    public void whenAddDuplicateChildToAnotherParent() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 55);
        tree.add(55, 1);
        List<Node<Integer>> arrNode2 = tree.findBy(55).get().leaves();
        assertThat(arrNode2.size(), is(0));
    }

    /**
     * Check if parent node is not exist in the tree.
     */
    @Test
    public void whenParentNodeNotExist() {
        Tree<Integer> tree = new Tree<>(1);
        boolean result = tree.add(3, 4);
        assertThat(result, is(false));
    }
}
