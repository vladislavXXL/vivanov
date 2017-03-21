package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* BubbleSort Test.
* @author vivanov
* @version 1
* @since 21.03.2017
*/

public class BubbleSortTest {

	/**
	* Test array {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
	*/
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort obj = new BubbleSort();
		int[] arr = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
		int[] result = obj.sort(arr);
		int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
		assertThat(result, is(expected));
	}
}