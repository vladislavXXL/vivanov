package ru.job4j2.collections.usersort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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

    /**
     * Method to sort Users by their names length.
     */
    @Test
    public void whenSortByNameLength() {
        List<User> list = new ArrayList<User>();
        list.addAll(Arrays.asList(
                new User("Alexey", 61),
                new User("Ivan", 61),
                new User("Dima", 61),
                new User("Dmitriy", 55),
                new User("Yuriy", 71),
                new User("Vladimir", 37)
        ));
        SortUser obj = new SortUser();
        List<User> result = new ArrayList<>();
        result = obj.sortNameLength(list);
        for (User el: result) {
            System.out.println(el);
        }
    }

    /**
     * Method to sort users by name and age fields.
     */
    @Test
    public void whenSortByAllFields() {
        List<User> list = new ArrayList<User>();
        list.addAll(Arrays.asList(
                new User("Alexey", 61),
                new User("Ivan", 61),
                new User("Dmitriy", 61),
                new User("Dmitriy", 13),
                new User("Yuriy", 71),
                new User("Vladimir", 37),
                new User("Dmitriy", 55)
        ));
        SortUser obj = new SortUser();
        List<User> result = new ArrayList<>();
        result = obj.sortByAllFields(list);
        for (User el: result) {
            System.out.println(el);
        }
    }
}