package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* RotateArray Test.
* @author vivanov
* @version 1
* @since 26.03.2017
*/

public class RotateArrayTest {

	/**
	* Test array {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
	*/
	@Test
	public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
		RotateArray obj = new RotateArray();
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] result = obj.rotate(arr);
		int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(result, is(expected));
	}

		/**
	* Test array {{1, 2}, {3, 4}}.
	*/
	@Test
	public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
		RotateArray obj = new RotateArray();
		int[][] arr = {{1, 2}, {3, 4}};
		int[][] result = obj.rotate(arr);
		int[][] expected = {{3, 1}, {4, 2}};
		assertThat(result, is(expected));
	}

}