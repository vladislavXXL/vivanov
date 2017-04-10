package ru.job4j.array;

/**
* Class ArrayMergeSort to merge a two sorted arrays and making sorted of result array.
* @author vivanov
* @version 1
* @since 11.04.2017
*/

public class ArrayMergeSort {

	/**
	* @param ar1 first array to merge and sort.
	* @param ar2 second array to merge and sort.
	* @return result array (merged and sorted).
	*/
	public int[] merge(int[] ar1, int[] ar2) {
		int temp = 0;
		int total = ar1.length + ar2.length;
		for (int i = 0; i < ar1.length; i++) {
			for (int j = 0; j < ar2.length; j++) {
                if (ar1[i] > ar2[j]) {
                    temp = ar1[i];
                    ar1[i] = ar2[j];
                    ar2[j] = temp;
                }
            }
        }
        int[] result = new int[total];
        for (int i = 0; i < ar1.length; i++) {
            result[i] = ar1[i];
        }
        for (int i = 0; i < ar2.length; i++) {
            for (int j = 0; j < ar2.length; j++) {
                if (ar2[i] > ar2[j]) {
                    temp = ar2[i];
                    ar2[i] = ar2[j];
                    ar2[j] = temp;
                }
            }
        }
        for (int i = ar1.length; i < total; i++) {
            result[i] = ar2[total - i - 1];
        }
		return result;
	}
}