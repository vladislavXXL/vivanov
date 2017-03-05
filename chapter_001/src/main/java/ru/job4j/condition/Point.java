package ru.job4j.condition;

/**
* Class Point.
* @author vivanov
* @since 05.03.2017
* @version 1
*
*/

public class Point {

	/**
	* Field x coordinate.
	*/
	private int x;

	/**
	* Field y coordinate.
	*/
	private int y;

	/**
	* Point class constructor.
	* @param x - x coordinate
	* @param y - y coordinate
	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	* Getting X coordinate.
	* @return x coordinate
	*/
	public int getX() {
		return this.x;
	}

	/**
	* Getting Y coordinate.
	* @return y coordinate
	*/
	public int getY() {
		return this.y;
	}

	/**
	* @param a - a parameter
	* @param b - b parameter
	* @return result - return true if X coordinate belongs to function y(x) = a * x + b.
	*/
	public boolean is(int a, int b) {
		boolean result = false;
		int func = a * this.x + b;
		if (this.y == func) {
			result = true;
		}
		return result;
	}

}