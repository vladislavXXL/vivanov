package ru.job4j2.tracker;

import java.sql.Connection;
import java.util.List;

/**
 * Interface Store.
 * @author v.ivanov
 * @version 1
 * @since 20.05.2020
 */
public interface Store extends AutoCloseable {

    /**
     * Method to initialize jdbc.
     * @return connection object
     */
    Connection init();

    /**
     * Method to add new item into database.
     * @param item instance to add
     * @return added item
     */
    Item add(Item item);

    /**
     * Method to replace item on specified item id.
     * @param id item id for replacing
     * @param item item with new values
     * @return result of operation
     */
    boolean replace(String id, Item item);

    /**
     * Method to delete item by id.
     * @param id id of item to delete
     * @return result of operation
     */
    boolean delete(String id);

    /**
     * Method to find all items.
     * @return list of items
     */
    List<Item> findAll();

    /**
     * Method to find item by name.
     * @param key item's name
     * @return list of items found by name
     */
    List<Item> findByName(String key);

    /**
     * Method to find item by id.
     * @param id of item
     * @return result item
     */
    Item findById(String id);
}
