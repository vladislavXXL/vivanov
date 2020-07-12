package ru.job4j2.tracker;

import java.util.Objects;

/**
 * Class Item.
 * @author vivanov
 * @version 1
 * @since 22.05.17
 */
public class Item {

    /** field id.*/
    private String id;

    /** field name.*/
    private String name;

    /** field description.*/
    private String desc;

    /** field creation time.*/
    private long created;

    /**
     * Class Item constructor without parametrs.
     */
    public Item() {
    }

    /**
     * Item constructor with parameters.
     * @param id - id
     * @param name - name
     * @param desc - description
     * @param created - creation time
     */
    public Item(String id, String name, String desc, long created) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    /**
     * Field id getter.
     * @return Item id.
     */
    public String getId() {
        return this.id;
    }

    /** Field name getter.
     * @return Item name
     */
    public String getName() {
        return this.name;
    }

    /** Field description getter.
     * @return Item description
     */
    public String getDesc() {
        return this.desc;
    }

    /** Created field getter.
     * @return creation date
     */
    public long getCreated() {
        return this.created;
    }

    /** Field id setter.
     * @param id - Item id
     */
    public void setId(String id) {
        this.id = id;
    }

    /** Field name setter.
     * @param name - Item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Field desc setter.
     * @param desc - Item description
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /** Field created setter.
     * @param created - the time in what Item was create
     */
    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name)
                && Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc);
    }
}
