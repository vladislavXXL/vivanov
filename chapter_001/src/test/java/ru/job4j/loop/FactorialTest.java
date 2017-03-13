package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Factorial calculating.
* @author vivanov
* @version 1
* @since 13.03.2017
*/

public class FactorialTest {

	/**
	* Factorial test n = 5.
	*/
	@Test
	public void whenFactorialIsFive() {
		Factorial obj = new Factorial();
		int expected = 120;
		assertThat(obj.calc(5), is(expected));
	}

	/**
	* Factorial test n = 0.
	*/
	@Test
	public void whenFactorialIsZero() {
		Factorial obj = new Factorial();
		int expected = 1;
		assertThat(obj.calc(0), is(expected));
	}
}