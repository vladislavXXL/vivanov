package ru.job4j.array;
import java.util.Arrays;

/**
* Class ArrayDuplicate to remove duplicates.
*/
public class ArrayDuplicate {

	/**
	* @param array to find and remove duplicates.
	* @return result of filtered array.
	*/
	public String[] remove(String[] array) {
        int total = array.length;
        int inc = 0;
        String temp = "";
        for (int i = 0; i < total - inc; i++) {
            for (int j = 0; j < total - inc; j++) {
                if (array[i].equals(array[j]) && i != j) {
                    inc++;
                    while (j < total - 1) {
                        temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                        j++;
                    }
                }
            }
        }
        return Arrays.copyOf(array, total - inc);
	}
}