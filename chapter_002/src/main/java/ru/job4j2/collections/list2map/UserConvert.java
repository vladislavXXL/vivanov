package ru.job4j2.collections.list2map;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert is used to convert list of users to map.
 * @author vivanov
 * @version 1
 * @since 13.02.2018
 */
public class UserConvert {

    /**
     * Method process is used to convert users list to map.
     * @param list with users
     * @return result map with users
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User user: list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}