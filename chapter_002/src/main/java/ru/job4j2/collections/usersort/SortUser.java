package ru.job4j2.collections.usersort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
