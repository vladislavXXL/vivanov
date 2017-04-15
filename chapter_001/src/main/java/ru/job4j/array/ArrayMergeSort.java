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
        int[] result = new int[ar1.length + ar2.length];
        int count = 0;
        int i = 0;
        int j = 0;

        while (i != ar1.length && j != ar2.length) {
            if (ar1[i] <= ar2[j]) {
                result[count] = ar1[i];
                count++;
                i++;
            } else if (ar2[j] <= ar1[i]) {
                result[count] = ar2[j];
                count++;
                j++;
            }
        }

        if (i < ar1.length) {
            System.arraycopy(ar1, i, result, count, ar1.length - i);
        } else if (j < ar2.length) {
            System.arraycopy(ar2, j, result, count, ar2.length - j);
        }

		return result;
	}
}