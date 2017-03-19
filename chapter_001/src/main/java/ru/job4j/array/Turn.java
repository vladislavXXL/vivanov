package ru.job4j.array;

/**
* Class Turn.
* @author vivanov
* @version 1
* @since 18.03.2017
*/

public class Turn {

	/**
	* @param array - array to turn
	* @return result - result array
	*/
	public int[] back(int[] array) {
		int temp = 0;
		int arrLen = array.length / 2;
            for (int i = 0; i < arrLen; i++) {
                temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
		return array;
	}
}