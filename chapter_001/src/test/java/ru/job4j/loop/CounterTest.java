package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Counter Test.
*
* @author vivanov
* @version 1
* @since 13.03.2017
*/
public class CounterTest {

	/**
	* Test range from 1 to 10.
	*/
	@Test
	public void whenAddOneToTen() {
		Counter obj = new Counter();
		int expected = 30;
		assertThat(obj.add(1, 10), is(expected));
	}
}
