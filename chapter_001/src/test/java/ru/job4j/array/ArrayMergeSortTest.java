package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* ArrayMergeSort Test.
* @author vivanov
* @version 1
* @since 11.04.2017
*/

public class ArrayMergeSortTest {

	/**
	* Test arrays {101, 105, 106, 107} and {2, 6, 103, 104, 120, 125}.
	*/
	@Test
	public void whenMergeArrayWithFiveAndSixElementsThenMergedSortedArray() {
		ArrayMergeSort obj = new ArrayMergeSort();
		int[] arr1 = {101, 105, 106, 107};
		int[] arr2 = {2, 6, 103, 104, 120, 125};
		int[] result = obj.merge(arr1, arr2);
		int[] expected = {2, 6, 101, 103, 104, 105, 106, 107, 120, 125};
		assertThat(result, is(expected));
	}
}