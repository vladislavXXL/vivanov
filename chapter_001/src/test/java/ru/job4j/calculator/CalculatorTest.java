package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Petr Arsentev (mailto:parsentev@yandex.ru)
* @version $Id$
* @since 0.1
*/
public class CalculatorTest {
	/**
	* Test add operation.
	*/

	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}

	/**
	* Test subtract operation.
	*/

	@Test
	public void whenAddTwoMinusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.subtract(2D, 1D);
		double result = calc.getResult();
		double expected = 1D;
		assertThat(result, is(expected));
	}

	/**
	* Test division operation.
	*/
	@Test
	public void whenAddSixDivTwoThenThree() {
		Calculator calc = new Calculator();
		calc.div(6D, 2D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}

	/**
	* Test multiplication operation.
	*/
	@Test
	public void whenAddThreeMultipleTwoThenSix() {
		Calculator calc = new Calculator();
		calc.multiple(3D, 2D);
		double result = calc.getResult();
		double expected = 6D;
		assertThat(result, is(expected));
	}
}