package ru.job4j3.collectionspro.map;

import java.util.Calendar;

/** Class User.
 * @author vivanov
 * @version 1
 * @since 11.07.2018
 */
public class User {

    /** Field name.*/
    private String name;

    /** Field Children.*/
    private int children;

    /** Field Birthday.*/
    private Calendar birthday;

    /**
     * User constructor.
     * @param name - name
     * @param children - quantity of children
     * @param birthday - birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Method hashCode.
     * @return int value
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + children;
        result = 31 * result + birthday.hashCode();
        return result;
    }
}
