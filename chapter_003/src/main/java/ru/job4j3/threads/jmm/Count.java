package ru.job4j3.threads.jmm;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Count.
 * @author v.ivanov
 * @version 1
 * @since 23.12.2018
 */
@ThreadSafe
public class Count {

    /** Field value.*/
    @GuardedBy("this")
    private int value;

    /**
     * Method to increment field value.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Method to get field value.
     * @return field value
     */
    public synchronized int get() {
        return this.value;
    }
}
