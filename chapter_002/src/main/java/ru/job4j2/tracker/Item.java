package ru.job4j2.tracker;

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

    /** field comments array.*/
    private String[] comments;

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
     * @param comments - some comments
     */
    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
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

    /** Field comments getter.
     * @return comments
     */
    public String[] getComments() {
        return this.comments;
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

    /** Field comments setter.
     * @param comments - additional comments for Item
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
