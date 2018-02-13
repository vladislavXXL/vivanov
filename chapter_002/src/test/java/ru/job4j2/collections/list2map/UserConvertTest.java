package ru.job4j2.collections.list2map;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class UserConvertTest to test class UserConvert.
 * @author vivanov
 * @version 1
 * @since 13.02.2018
 */
public class UserConvertTest {

    /**
     * Method to test UserConvert.
     */
    @Test
    public void whenConvertListToMap() {

        User user1 = new User(1, "Ivanov", "Moscow");
        User user2 = new User(2, "Petrov", "Novosibirsk");
        User user3 = new User(3, "Sidorov", "Omsk");
        User user4 = new User(101, "Kozlov", "Tomsk");

        List<User> list = Arrays.asList(user1, user2, user3, user4);

        UserConvert obj = new UserConvert();
        HashMap<Integer, User> result = obj.process(list);

        HashMap<Integer, User> expect = new HashMap<Integer, User>();
        expect.put(1, user1);
        expect.put(2, user2);
        expect.put(3, user3);
        expect.put(101, user4);

        assertThat(expect, equalTo(result));
    }
}
