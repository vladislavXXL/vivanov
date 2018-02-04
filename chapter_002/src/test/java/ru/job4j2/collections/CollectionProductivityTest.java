package ru.job4j2.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Class CollectionProductivityTest to test class CollectionProductivity.
 * @author vivanov
 * @version 1
 * @since 01.02.2018
 */
public class CollectionProductivityTest {

    /**
     * Method to get execution time when using add and delete operation with LinkedList.
     */
    @Test
    public void whenUsedLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        CollectionProductivity obj = new CollectionProductivity();
        long timeAdd = obj.add(ll, 100000);
        System.out.println("LinkedList Add: " + timeAdd);
        long timeDelete = obj.delete(ll, 50000);
        System.out.println("LinkedList Delete: " + timeDelete);
    }

    /**
     * Method to get execution time when using add and delete operations with ArrayList.
     */
    @Test
    public void whenUsedArrayList() {
        ArrayList<String> al = new ArrayList<String>();
        CollectionProductivity obj = new CollectionProductivity();
        long timeAdd = obj.add(al, 100000);
        System.out.println("ArrayList Add: " + timeAdd);
        long timeDelete = obj.delete(al,50000);
        System.out.println("ArrayList Delete: " + timeDelete);
    }

    /**
     * Method to get execution time when using add and delete operations with TreeSet.
     */
    @Test
    public void whenUsedTreeSet() {
        TreeSet<String> ts = new TreeSet<String>();
        CollectionProductivity obj = new CollectionProductivity();
        long timeAdd = obj.add(ts, 100000);
        System.out.println("TreeSet Add: " + timeAdd);
        long timeDelete = obj.delete(ts, 50000);
        System.out.println("TreeSet Delete: " + timeDelete);
    }
}