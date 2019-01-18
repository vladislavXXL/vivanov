package ru.job4j3.collectionspro.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

/**
 * Class DynamicArrayThreadSafe.
 * @param <E> parametrized type
 * @author v.ivanov
 * @version 1
 * @since 16.01.2019
 */
@ThreadSafe
public class DynamicArrayThreadSafe<E> implements Iterable<E> {

    /** Field DynamicArray instance.*/
    @GuardedBy("this")
    private DynamicArray<E> array;

    /**
     * DynamicArrayThreadSafe constructor.
     * @param array DynamicArray instance
     */
    public DynamicArrayThreadSafe(DynamicArray<E> array) {
        this.array = array;
    }

    /**
     * Get iterator() method.
     * @return iterator
     */
    public synchronized Iterator<E> iterator() {
        return copy(this.array).iterator();
    }

    /**
     * Copy instance of iterator.
     * @param array DynamicArray instance
     * @return DynamicArray instance
     */
    public DynamicArray<E> copy(DynamicArray<E> array) {
        synchronized (this) {
            return this.array;
        }
    }

    /**
     * Method to get element.
     * @param index index of element
     * @return element value
     */
    public synchronized E get(int index) {
        return this.array.get(index);
    }

    /**
     * Method to add element to array.
     * @param value element value
     */
    public synchronized void add(E value) {
        this.array.add(value);
    }

    /**
     * Method to set value.
     * @param index index of element
     * @param value elemnt value
     * @return result of operation
     */
    public synchronized boolean set(int index, E value) {
        return this.array.set(index, value);
    }
}
