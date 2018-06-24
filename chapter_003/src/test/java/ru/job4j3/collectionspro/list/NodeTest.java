package ru.job4j3.collectionspro.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class NodeTest to test class Node.
 * @author vivanov
 * @version 1
 * @since 24.06.2018
 */
public class NodeTest {

    /** First element.*/
    private Node<Integer> first;

    /** Second element.*/
    private Node<Integer> second;

    /** Third element.*/
    private Node<Integer> third;

    /** Fourth element.*/
    private Node<Integer> fourth;

    /** Fifth element.*/
    private Node<Integer> fifth;

    /** Fifth element.*/
    private Node<Integer> sixth;

    /**
     * Class Node initialization.
     */
    @Before
    public void setUp() {
        this.first = new Node<>(1);
        this.second = new Node<>(2);
        this.third = new Node<>(3);
        this.fourth = new Node<>(4);
        this.fifth = new Node<>(5);
        this.sixth = new Node<>(6);

        this.first.setNext(second);
        this.second.setNext(third);
        this.third.setNext(fourth);
        this.fourth.setNext(fifth);
        this.fifth.setNext(sixth);
        this.sixth.setNext(first);
    }

    /**
     * Method to check hasCycle().
     */
    @Test
    public void checkHasCycle() {
        boolean result = Node.hasCycle(this.first);
        assertThat(result, is(true));
    }





}