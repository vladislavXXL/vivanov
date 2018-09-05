package ru.job4j3.collectionspro.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author vivanov
 * @version 1
 * @since 24.08.2018
 * @param <K> key
 * @param <V> value
 */
public class CustomHashMap<K, V> implements Iterable<K> {

    /** Field load factory.*/
    private static final double LOAD_FACTORY = 0.5;

    /** Field map default map size.*/
    private static final int MAP_SIZE = 6;

    /** Field map size.*/
    private int size = 0;

    /** Associative array with keys and values.*/
    private Entry<K, V>[] array;

    /**
     * CustomHashMap constructor.
     */
    public CustomHashMap() {
        this.array = new Entry[this.MAP_SIZE];
    }

    /**
     * Method to insert new key and value.
     * @param key - key
     * @param value - value
     * @return true if insert successfully
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        double curLoad = this.size / this.array.length;
        if (curLoad > this.LOAD_FACTORY) {
            mapResize();
        }
        int hash = key.hashCode();
        int index = hash % this.array.length;
        if (this.array[index] == null) {
            this.array[index] = new Entry<>(hash, key, value);
            this.size++;
            result = true;
        }
        return result;
    }

    /**
     * Method to get value by key.
     * @param key - key
     * @return result value
     */
    public V get(K key) {
        V result = null;
        int hash = key.hashCode();
        int index = hash % this.array.length;
        if (this.array != null && this.array[index] != null) {
            if (this.array[index].hash == hash && this.array[index].key.equals(key)) {
                result = this.array[index].getValue();
            }
        }
        return result;
    }

    /**
     * Method to delete key and value by key.
     * @param key - key
     * @return true if delete successfully
     */
    public boolean delete(K key) {
        boolean result = false;
        int hash = key.hashCode();
        int index = hash % this.array.length;
        if (this.array != null && this.array[index] != null) {
            if (this.array[index].hash == hash && this.array[index].key.equals(key)) {
                this.array[index] = null;
                this.size--;
                result = true;
            }
        }
        return result;
    }

    /**
     * Method to make map resize.
     */
    public void mapResize() {
        Entry<K, V>[] mapToResize = this.array;
        int newSize = this.array.length * 2;
        this.array = (Entry<K, V>[]) new Entry[newSize];
        for (int i = 0; i < mapToResize.length; i++) {
            if (mapToResize[i] != null) {
                Entry<K, V> item = mapToResize[i];
                int index = item.hash % newSize;
                this.array[index] = item;
            }
        }


    }

    /**
     * Return size of map.
     * @return size
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<K> iterator() {
        return new HashMapIterator<>();
    }

    /**
     * Class HashMapIterator to implement iterator.
     * @param <K> key
     */
    public class HashMapIterator<K> implements Iterator<K> {

        /** Field iterator index.*/
        private int itrIndex = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
            while (this.itrIndex < array.length) {
                if (array[this.itrIndex] != null) {
                    result = true;
                    break;
                }
                this.itrIndex++;
            }
            return result;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public K next() {
            if (hasNext() && array[this.itrIndex] != null) {
                return (K) array[this.itrIndex++].getKey();
            }
            throw new NoSuchElementException();
        }
    }

    /**
     * Class Entry to implement keys and values.
     * @param <K> - key
     * @param <V> - value
     */
    public class Entry<K, V> {

        /** Field hash.*/
        private int hash;

        /** Field key.*/
        private K key;

        /** Field value.*/
        private V value;

        /**
         * Class Entry constructor.
         * @param hash - hash
         * @param key - key
         * @param value - value
         */
        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        /**
         * Key getter.
         * @return key value
         */
        public K getKey() {
            return this.key;
        }

        /**
         * Value getter.
         * @return value
         */
        public V getValue() {
            return this.value;
        }
    }
}
