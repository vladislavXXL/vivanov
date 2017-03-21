package ru.job4j.array;

/**
* Class BubbleSort to sort array.
* @author vivanov
* @version 1
* @since 19.03.2017
*/

public class BubbleSort {

	/**
	* @param array - array to sort.
	* @return sorted array
	*/
	public int[] sort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
	}
}