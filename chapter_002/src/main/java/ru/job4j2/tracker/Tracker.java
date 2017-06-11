package ru.job4j2.tracker;

import java.util.Arrays;

/**
 * Class Tracker.
 * @author vivanov
 * @version 1
 * @since 22.05.17
 */
public class Tracker {

    /** Field items that belongs to tracker.*/
    private Item[] items = new Item[100];

    /** Field index - counter of items.*/
    private int index = 0;

    /**
     * Method to add item.
     * @param item - item to add
     * @return item
     */
    public Item add(Item item) {
        this.items[index++] = item;
        return item;
    }

    /**
     * Method to update item.
     * @param item - item to update
     */
    public void update(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (item.getId().equals(this.items[i].getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * Methode to delete item.
     * @param item - item to delete
     */
    public void delete(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (item.getId().equals(this.items[i].getId())) {
                //this.items[i] = null;
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                this.items[this.items.length - 1] = null;
                break;
            }
        }
        this.index--;
    }

    /**
     * Method to get all items.
     * @return array of all items
     */
    public Item[] getAll() {
        return this.items;
    }

    /**
     * Method to find all not null items.
     * @return array of items
     */
    public Item[] findAll() {
        int inc = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                inc = i;
                break;
            }
        }
        return Arrays.copyOf(this.items, inc);
    }

    /**
     * Method to find item by id.
     * @param id - id ot the item
     * @return result
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.items.length; i++) {
            if (id.equals(this.items[i].getId())) {
                result = this.items[i];
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
    public Item[] findByName(String key) {
        int inc = 0;
        Item[] result = new Item[this.items.length];
        for (Item el: this.items) {
            if (el.getName().equals(key)) {
                result[inc] = el;
                inc++;
            }
        }
        return Arrays.copyOf(result, inc);
    }
}