package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
//import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* Triangle area test.
* @author vivanov
* @version 1
* @since 11.03.2017
*/

public class TriangleTest {

	/**
	* Test A(1, 1), B(1, 5), C(3, 5).
	*/
	@Test
	public void whenAOneOneAndBOneFiveAndCThreeFive() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 5);
		Point c = new Point(3, 5);
		Triangle shape = new Triangle(a, b, c);
		double result = shape.area();
		double expected = 4.0;
		assertThat(result, closeTo(expected, 0.01));
	}

	/**
	* Test A(2, 0), B(3, 5), C(3, 6).
	*/
	@Test
	public void test2() {
		Point a = new Point(2, 0);
		Point b = new Point(3, 5);
		Point c = new Point(3, 6);
		Triangle shape = new Triangle(a, b, c);
		double result = shape.area();
		double expected = 0.5;
		assertThat(result, closeTo(expected, 0.01));
	}
}