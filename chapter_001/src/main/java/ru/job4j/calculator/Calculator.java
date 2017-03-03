package ru.job4j.calculator;
/**
* Class Calculator.
* @author vivanov
* @since 28.02.2017
* @version 1
*
*
*/
public class Calculator {
	/**
	* Calculator operation result.
	* @param args - args
	*/

	private double result;

	/**
	* Addition operation.
	* @param first - first parameter
	* @param second - second parameter
	*/

	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	* Subtract operation.
	* @param first - first parameter
	* @param second - second parameter
	*/
	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	* Division operation.
	* @param first - first parameter
	* @param second - second parameter
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	* Multiplication operation.
	* @param first - first parameter
	* @param second - second parameter
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	* Getting result.
	* @return result
	*/
	public double getResult() {
		return this.result;
	}
}