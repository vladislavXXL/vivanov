package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* ArrayDuplicate Test.
* @author vivanov
* @version 1
* @since 06.04.2017
*/

public class ArrayDuplicateTest {

	/**
	* Test array {"Привет", "Мир", "Привет", "Супер", "Мир"}.
	*/
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate obj = new ArrayDuplicate();
		String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
		String[] expected = {"Привет", "Мир", "Супер"};
		String[] result = obj.remove(array);
		assertThat(result, is(expected));
	}
}