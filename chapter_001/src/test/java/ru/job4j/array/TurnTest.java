package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Turn Tests.
*
* @author vivanov
* @version 1
* @since 19.03.2017
*/
public class TurnTest {

	/**
	* Test array {1, 2, 3, 4, 5}.
	*/
	@Test
	public void whenAddOddArray() {
		Turn obj = new Turn();
		int[] arr = {1, 2, 3, 4, 5};
		int[] result = obj.back(arr);
		int[] expected = {5, 4, 3, 2, 1};
		for (int i = 0; i < result.length; i++) {
			assertThat(result[i], is(expected[i]));
		}
	}

	/**
	* Test array {4, 1, 6, 2}.
	*/
	@Test
	public void whenAddEvenArray() {
		Turn obj = new Turn();
		int[] arr = {4, 1, 6, 2};
		int[] result = obj.back(arr);
		int[] expected = {2, 6, 1, 4};
		for (int i = 0; i < result.length; i++) {
			assertThat(result[i], is(expected[i]));
		}
	}
}