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
}
