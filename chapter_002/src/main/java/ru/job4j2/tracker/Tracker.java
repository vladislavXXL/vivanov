package ru.job4j2.tracker;

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
        for (Item el: this.items) {
            if (el.getId().equals(item.getId())) {
                if (item.getId() != null) {
                    el.setId(item.getId());
                }
                if (item.getName() != null) {
                    el.setName(item.getName());
                }
                if (item.getDesc() != null) {
                    el.setDesc(item.getDesc());
                }
                if (item.getCreated() != 0) {
                    el.setCreated(item.getCreated());
                }
                if (item.getComments() != null) {
                    el.setComments(item.getComments());
                }
            }
        }
    }

    /**
     * Methode to delete item.
     * @param item - item to delete
     */
    public void delete(Item item) {
        for (Item el: this.items) {
            if (item.equals(el)) {
                el = null;
            }
        }
    }

    /**
     * Method to get all items.
     * @return array of all items
     */
    public Item[] findAll() {
        return this.items;
    }

    /**
     * Method to find items by name.
     * @param key - name of item
     * @return result - result array with items
     */
    public Item[] findByName(String key) {
        int inc = 0;
        for (Item el: this.items) {
            if (el.getName().equals(key)) {
                inc++;
            }
        }
        Item[] result = null;
        if (inc > 0) {
            result = new Item[inc];
            inc = 0;
            for (Item el : this.items) {
                if (el.getName().equals(key)) {
                    result[inc] = el;
                    inc++;
                }
            }
        }
        return result;
    }

    /**
     * Method to find item by id.
     * @param id - id ot the item
     * @return result
     */
    public Item findById(String id) {
        Item result = null;

        for (Item el: this.items) {
            if (el.getId().equals(id)) {
                result = el;
            }
        }
        return result;
    }
}
