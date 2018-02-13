package ru.job4j2.collections.list2map;

/**
 * Class User.
 * @author vivanov
 * @version 1
 * @since 13.02.2018
 */
public class User {

    /** field id. */
    private int id;

    /** field name. */
    private String name;

    /** field city. */
    private String city;

    /**
     * Constructor of class User.
     * @param id - user id
     * @param name - user name
     * @param city - user city
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter of id field.
     * @return user's id
     */
    public int getId() {
        return id;
    }
}