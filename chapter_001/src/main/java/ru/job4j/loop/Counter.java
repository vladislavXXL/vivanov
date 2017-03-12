package ru.job4j.loop;

/**
* Class Counter.
* @author vivanov
* @since 13.03.2017
* @version 1
*/

public class Counter {

	/**
	* Method returns the sum of even numbers from the range.
	* @param start - the start position in the range
	* @param finish - the end position in the range
	* @return the sum of even numbers from the range
	*/
	public int add(int start, int finish) {
		int sum = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}