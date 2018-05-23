package ru.job4j3.collectionspro.generic;

/**
 * @author vivanov
 * @version 1
 * @since 13.05.2018
 * @param <T>
 */
public interface Store<T extends Base> {
    /**
     * Method to add new model.
     * @param model new model
     */
    void add(T model);

    /**
     * Method to replace model.
     * @param id id of model to replace
     * @param model new model value
     * @return result of operation
     */
    boolean replace(String id, T model);

    /**
     * Method to delete model by id.
     * @param id id of model to delete
     * @return result of operation.
     */
    boolean delete(String id);

    /**
     * Method to find model by id.
     * @param id model searching id
     * @return searched model
     */
    T findById(String id);
}
