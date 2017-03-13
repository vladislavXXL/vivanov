package ru.job4j.loop;

/**
* Class Factorial.
* @author vivanov
* @since 13.03.2017
* @version 1
*/

public class Factorial {

	/**
	* Calculating factorial.
	* @param n - parameter to calculate
	* @return total - result of calculating n!
	*/
	public int calc(int n) {
		int total = 1;
		for (int i = 1; i <= n; i++) {
			total = total * i;
		}
		return total;
	}
}