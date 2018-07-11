package ru.job4j3.collectionspro.map;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Class UserTest to test class User.
 * @author vivanov
 * @version 1
 * @since 11.07.2018
 */
public class UserTest {
    /** Field user1.*/
    private User user1 = new User("Vasiliy", 2, new GregorianCalendar(1986, 01, 15));

    /** Field user2.*/
    private User user2 = new User("Vasiliy", 2, new GregorianCalendar(1986, 01, 15));

    /** Field map.*/
    private Map<User, Object> map = new HashMap<>();

    /**
     * Initialize block.
     */
    @Before
    public void setUp() {
        map.put(user1, "1st");
        map.put(user2, "2nd");
    }

    /**
     * Method to print out map.
     */
    @Test
    public void whenPrintMap() {
        System.out.println(map);
    }
}