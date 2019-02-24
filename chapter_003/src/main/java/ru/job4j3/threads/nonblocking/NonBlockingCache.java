package ru.job4j3.threads.nonblocking;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class NonBlockingCache to store models.
 *
 * @author v.ivanov
 * @version 1
 * @since 23.02.2019
 */
public class NonBlockingCache {

    /** Field to store cache.*/
    private ConcurrentHashMap<Integer, Base> store;

    /**
     * Class NonBlockingCache constructor.
     */
    public NonBlockingCache() {
        this.store = new ConcurrentHashMap<>();
    }

    /**
     * Field store getter method.
     * @return store ConcurrentHashMap
     */
    public ConcurrentHashMap<Integer, Base> getStore() {
        return this.store;
    }

    /**
     * Method to add a model to the store.
     *
     * @param model model to add
     */
    public void add(Base model) {
        this.store.put(model.getId(), model);
    }

    /**
     * Delete model from cache store.
     *
     * @param model instance to delete
     * @return deleted instance
     */
    public Base delete(Base model) {
        return this.store.remove(model.getId());
    }

    /**
     * Update model by id.
     *
     * @param model new value
     */
    public void update(Base model) {
        this.store.computeIfPresent(model.getId(), (k, v) -> {
                if (v.getVersion() != model.getVersion()) {
                    throw new OptimisticException("Data has been changed while working process!");
                }
                model.incVersion();
                return model;
                }
        );
    }
}
