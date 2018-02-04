package ru.job4j2.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * Class CollectionProductivity is used to compare the processing speed different collections.
 * @author vivanov
 * @version 1
 * @since 01.02.2018
 */
public class CollectionProductivity {

/*
    Collection collection;

    */
/**
     * Constructor of class CollectionProductivity.
     * @param collection - can be LinkedList, ArrayList or TreeSet
     *//*

    public void CollectionProductivity(Collection collection) {
        this.collection = collection;
    }
*/

    /**
     * Method add is used to put elements into collection.
     * @param collection - can be LinkedList, ArreyList or TreeSet
     * @param amount - amount of elements
     * @return the time execution of operation
     */
    public long add(Collection<String> collection, int amount) {

        Random r = new Random();
        StringBuilder str = new StringBuilder();
        long start = System.currentTimeMillis();

        while (amount >= 0) {
            for (int i = 0; i < 5; i++) {
                char c = (char) (r.nextInt(26) + 'a');
                str.append(c);
            }
            collection.add(str.toString());
            str.setLength(0);
            amount--;
        }

        long end = System.currentTimeMillis();

        return end - start;
    }

    /**
     * Method delete is used to delete elements from collection.
     * @param collection - can be LinkedList, ArreyList or TreeSet
     * @param amount - quantity of first elements to delete from collection
     * @return the time execution of operation
     */
    public long delete(Collection<String> collection, int amount) {

        long start = System.currentTimeMillis();
        Iterator<String> itr = collection.iterator();
        while (itr.hasNext()) {
            itr.next();
            if (amount >= 0) {
                itr.remove();
                amount--;
            }
        }

        long end = System.currentTimeMillis();
        return end - start;
    }
}