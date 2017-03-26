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
        for (int i = 0; i <= len / 2 - 1; i++) {
            int endPoint = len - i - 2;
            for (int j = len - i; j >= len - endPoint; j--) {
                temp = array[i][len - j];
                array[i][len - j] = array[j - 1][i];
                array[j - 1][i] = array[len - 1 - i][j - 1];
                array[len - 1 - i][j - 1] = array[len - j][len - 1 - i];
                array[len - j][len - 1 - i] = temp;
            }
        }
		return array;
	}
}