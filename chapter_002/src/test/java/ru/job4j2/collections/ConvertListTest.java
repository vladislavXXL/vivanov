package ru.job4j2.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class ConvertListTest is used to test class ConvertList.
 * @author vivanov
 * @version 1
 * @since 07.02.2018
 */
public class ConvertListTest {

    /**
     * Method to test converting array to ArrayList.
     */
    @Test
    public void whenConvertArrayToList() {
        ConvertList obj = new ConvertList();
        int[][] arr = {{3, 2, 1}, {6, 5, 4}};
        List<Integer> result = obj.toList(arr);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(3);
        expected.add(2);
        expected.add(1);
        expected.add(6);
        expected.add(5);
        expected.add(4);
        assertThat(expected, equalTo(result));
    }

    /**
     * Method to convert ArrayList ot array.
     */
    @Test
    public void whenConvertListToArray() {
        ConvertList obj = new ConvertList();
        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        int[][] result = obj.toArray(al, 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        assertThat(expect, equalTo(result));
    }

    /**
     * Method to convert List<int[]> to List<Integer>.
     */
    @Test
    public void whenConvertListIntToListInteger() {
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        ConvertList obj = new ConvertList();
        List<Integer> result = obj.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(expect, equalTo(result));
    }
}
