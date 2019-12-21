package ru.job4j2.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;

/**
 * ListToMapTest class.
 *
 * @author v.ivanov
 * @version 1
 * @since 22.12.2019
 */
public class ListToMapTest {

    /**
     * Check Stream API converting list to map.
     */
    @Test
    public void checkConvertListToMap() {
        School school = new School();
        List<Student> list = Arrays.asList(
                new Student("Arkadiy Semenov", 99),
                new Student("Vovochka", 23),
                new Student("Sibiryakova Angella", 90),
                new Student("Snezhanna Andreeva", 60),
                new Student("Dmitriy Dmitriev", 88),
                new Student("Denis", 54),
                new Student("Valera", 33)
        );
        Map<String, Student> expectedMap = new HashMap<String, Student>() {
            {
                put(list.get(0).getName(), list.get(0));
                put(list.get(1).getName(), list.get(1));
                put(list.get(2).getName(), list.get(2));
                put(list.get(3).getName(), list.get(3));
                put(list.get(4).getName(), list.get(4));
                put(list.get(5).getName(), list.get(5));
                put(list.get(6).getName(), list.get(6));
            }
        };
        Map<String, Student> actualMap = school.listToMap(list);
        Assert.assertThat(expectedMap, is(actualMap));
    }
}
