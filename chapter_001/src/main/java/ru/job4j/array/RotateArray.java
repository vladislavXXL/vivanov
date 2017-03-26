package ru.job4j.array;

/**
* Class RotateArray to 90 degrees array rotate.
* @author vivanov
* @version 1
* @since 1
*/

public class RotateArray {

	/**
	* @param array - array to rotate
	* @return rotated array
	*/
	public int[][] rotate(int[][] array) {
		int temp = 0;
		int len = array.length;
		int endPoint = len - 2;
        for (int i = len; i >= len - endPoint; i--) {
            temp = array[0][len - i];
            array[0][len - i] = array[i - 1][0];
            array[i - 1][0] = array[len - 1][i - 1];
            array[len - 1][i - 1] = array[len - i][len - 1];
            array[len - i][len - 1] = temp;
        }
		return array;
	}
}