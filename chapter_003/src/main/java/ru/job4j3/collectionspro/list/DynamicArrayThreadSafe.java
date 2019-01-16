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
public class DynamicArrayThreadSafe<E> extends DynamicArray<E> {

    /** Field DynamicArray instance.*/
    @GuardedBy("this")
    private DynamicArray<E> array;

    /**
     * DynamicArrayThreadSafe constructor.
     */
    public DynamicArrayThreadSafe() {
        this.array = new DynamicArray<>();
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
     * Method to add new element.
     * @param value value of new element
     */
    public synchronized void add(E value) {
        this.array.add(value);
    }

    /**
     * Method to get element by index.
     * @param index index of array element to get
     * @return value
     */
    public synchronized E get(int index) {
        return this.array.get(index);
    }
}
