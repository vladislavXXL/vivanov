package ru.job4j2.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Tracker.
 * @author vivanov
 * @version 1
 * @since 22.05.17
 */
public class MemTracker {

    /** Field items that belongs to tracker.*/
    private List<Item> items = new ArrayList<Item>();

    /**
     * Method to add item.
     * @param item - item to add
     * @return item
     */
    public Item add(Item item) {
        this.items.add(item);
        return item;
    }

    /**
     * Method to update item.
     * @param item - item to update
     */
    public void update(Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (item.getId().equals(this.items.get(i).getId())) {
                this.items.set(i, item);
                break;
            }
        }
    }

    /**
     * Methode to delete item.
     * @param item - item to delete
     */
    public void delete(Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (item.getId().equals(this.items.get(i).getId())) {
                this.items.remove(i);
                break;
            }
        }
    }

    /**
     * Method to get all items.
     * @return array of all items
     */
    public List<Item> getAll() {
        return this.items;
    }

    /**
     * Method to find all not null items.
     * @return array of items
     */
    public List<Item> findAll() {
        int inc = 0;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) == null) {
                inc = i;
                break;
            }
        }
        return this.items.subList(0, inc + 1);
    }

    /**
     * Method to find item by id.
     * @param id - id ot the item
     * @return result
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(this.items.get(i).getId())) {
                result = this.items.get(i);
                break;
            }
        }
        return result;
    }

    /**
     * Method to find items by name.
     * @param key - name of item
     * @return result - result array with items
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<Item>();
        for (Item el: this.items) {
            if (el != null && el.getName().equals(key)) {
                result.add(el);
            }
        }
        return result;
    }
}