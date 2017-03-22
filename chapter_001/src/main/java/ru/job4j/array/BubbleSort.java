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
        int arrLen = array.length;
        boolean isGreat = false;
        for (int i = 0; i < arrLen - 1; i++) {
            for (int j = 0; j < arrLen - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isGreat = true;
                }
                for (int arr : array) {
                    System.out.print(arr + ", ");
                }
                System.out.println();
            }
            if (!isGreat) {
                break;
            }
        }
        return array;
	}
}