package ru.job4j2.collections.usersort;

import org.junit.Test;

import java.util.*;

/**
 * Class UserSortTest to test sorting.
 * @author vivanov
 * @version 1
 * @since 19.02.2018
 */
public class SortUserTest {

    /**
     * Method to test sorting of users by age.
     */
    @Test
    public void whenSortUserTest() {
        List<User> list = new ArrayList<User>();
        list.addAll(Arrays.asList(
                new User("Alexey", 61),
                new User("Dmitriy", 55),
                new User("Yuriy", 71),
                new User("Vladimir", 37)
        ));
        SortUser obj = new SortUser();
        Set<User> result = new TreeSet<User>();
        result = obj.sort(list);

        for (User el: result) {
            System.out.println(el);
        }
    }
}
