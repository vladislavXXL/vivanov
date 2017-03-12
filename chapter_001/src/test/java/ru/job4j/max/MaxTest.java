package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Max Test.
*
* @author vivanov
* @version $Id$
* @since 0.1
*/
public class MaxTest {

	/**
	* Test with 10 and 19.
	*/
	@Test
	public void whenAddTenAndNineteenThenNineteen() {
		Max obj = new Max();
		int result = obj.max(10, 19);
		int expected = 19;
		assertThat(result, is(expected));
	}

	/**
	* Test with 8 and -1.
	*/
	@Test
	public void whenAddEightAndMinusOneThenEight() {
		Max obj = new Max();
		int result = obj.max(8, -1);
		int expected = 8;
		assertThat(result, is(expected));
	}

	/**
	* Test max with three parameter.
	* Test with 3, 6 and 19
	*/
	@Test
	public void whenAddThreeAndSixAndNineteen() {
		Max obj = new Max();
		int result = obj.max(3, 6, 19);
		int expected = 19;
		assertThat(result, is(expected));
	}
}