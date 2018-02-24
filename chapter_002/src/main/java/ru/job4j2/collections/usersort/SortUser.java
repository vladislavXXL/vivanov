package ru.job4j2.collections.usersort;

//import java.util.*;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Collections;

/**
 * Class SortUser to sort List into Set.
 * @author vivanov
 * @version 1
 * @since 19.02.2018
 */
public class SortUser {

    /**
     * Method to make sort of users by age.
     * @param list of users to sort
     * @return result sorted by age TreeSet
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<User>();
        for (User el: list) {
            result.add(el);
        }
        return result;
    }

    /**
     * Method to compare Users by name length.
     * @param list of Users
     * @return sorted list
     */
    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer name1 = o1.getName().length();
                Integer name2 = o2.getName().length();
                return name1.compareTo(name2);
            }
        });
        return list;
    }

    /**
     * Method to compare Users by name and age fields.
     * @param list of Users
     * @return sorted list
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int lastName = o1.getName().compareTo(o2.getName());
                if (lastName == 0) {
                    return o1.getAge().compareTo(o2.getAge());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        return list;
    }
}