package ru.job4j.condition;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Point.
* @author vivanov
* @version 1
* @since
*/

public class PointTest {

	/**
	* Test a = 2, b = 3, x = 2, y = 7.
	*/
	@Test
	public void whenAIsTwoAndBIsThreeThanTrue() {
		Point point = new Point(2, 7);
		boolean result = point.is(2, 3);
		boolean expected = true;
		assertThat(result, is(expected));
	}

	/**
	* Test a = 3, b = 10, x = 2, y =7.
	*/
	@Test
	public void whenAisThreeAndBIsTenThanFalse() {
		Point point = new Point(2, 7);
		boolean result = point.is(3, 10);
		boolean expected = false;
		assertThat(result, is(expected));
	}

}