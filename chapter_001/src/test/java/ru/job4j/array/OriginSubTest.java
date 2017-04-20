package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class OriginSub test.
* @author vivanov
* @version 1
* @since 20.04.2017
*/

public class OriginSubTest {

	/**
	* Test line: "This is full line". Subline: "is full".
	*/
	@Test
	public void whenCompareTwoLines() {
		OriginSub obj = new OriginSub();
		String str1 = "This is full line";
		String str2 = "is full";
		boolean result = obj.contains(str1, str2);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}