package ru.job4j3.collectionspro.generic;

import java.util.Iterator;

/**
 * AbstractStore class.
 * @param <T> parametrized type parameter
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /** Field with data.*/
    private SimpleArray<T> dataStore;

    /**
     * Class UserStore constructor.
     * @param size size of userStoreData array field
     */
    public AbstractStore(int size) {
        this.dataStore = new SimpleArray<>(size);
    }

    /**
     * Method to add new model.
     *
     * @param model new model
     */
    @Override
    public void add(T model) {
        this.dataStore.add(model);
    }

    /**
     * Method to replace model.
     *
     * @param id    id of model to replace
     * @param model new model value
     * @return result of operation
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        Iterator<T> iterator = this.dataStore.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            T data = iterator.next();
            if (data.getId().equals(id)) {
                this.dataStore.set(count, model);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    /**
     * Method to delete model by id.
     *
     * @param id id of model to delete
     * @return result of operation.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        Iterator<T> iterator = this.dataStore.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            T data = iterator.next();
            if (data.getId().equals(id)) {
                this.dataStore.delete(count);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    /**
     * Method to find model by id.
     *
     * @param id model searching id
     * @return searched model
     */
    @Override
    public T findById(String id) {
        Iterator<T> iterator = this.dataStore.iterator();
        T result = null;
        while (iterator.hasNext()) {
            T data = iterator.next();
            if (data.getId().equals(id)) {
                result = data;
                break;
            }
        }
        return result;
    }
}