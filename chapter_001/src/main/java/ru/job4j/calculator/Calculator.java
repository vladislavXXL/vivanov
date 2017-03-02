package ru.job4j.calculator;
/**
* Class Класс Calculator.
* @author vivanov
* @since 28.02.2017
* @version 1
*
*
*/
public class Calculator {
	/**
	* Результат.
	* @param args - args
	*/

	private double result;

	/**
	* Простой калькулятор.
	* @param first - первое число
	* @param second - второе число
	*/

	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	* Простой калькулятор.
	* @param first - первое число
	* @param second - второе число
	*/
	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	* Простой калькулятор.
	* @param first - первое число
	* @param second - второе число
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	* Простой калькулятор.
	* @param first - первое число
	* @param second - второе число
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	* Метод вывода результата.
	* @return result
	*/
	public double getResult() {
		return this.result;
	}
}