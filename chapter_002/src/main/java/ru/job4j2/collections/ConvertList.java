package ru.job4j2.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertList is used to convert array to ArrayList or ArrayList to array.
 * @author vivanov
 * @version 1
 * @since 07.02.2018
 *
 */
public class ConvertList {

    /**
     * Method is used to convert array to ArrayList.
     * @param array that will be convert to ArrayList
     * @return result ArrayList
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] i: array) {
            for (int j: i) {
                result.add(j);
            }
        }
        return result;
    }

    /**
     * Method is used to convert ArrayList to array.
     * @param list that will be convert to array
     * @param rows - rows quantity of result array
     * @return array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        double iLen = (double) list.size() / rows;
        iLen = Math.ceil(iLen);
        int[][] result = new int[rows][(int) iLen];
        int i = 0;
        int j = 0;
        for (int el: list) {
            result[i][j++] = el;
            if (j >= iLen) {
                i++;
                j = 0;
            }
        }
        return result;
    }

    /**
     * Method is used to convert List<int[]> to List<Integer>.
     * @param list to convert
     * @return result
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] arr: list) {
            for (int el: arr) {
                result.add(el);
            }
        }
        return result;
    }
}