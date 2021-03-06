package ru.job4j.max;

/**
* Class Max.
* @author vivanov
* @since 04.03.2017
* @version 1
*/

public class Max {

	/**
	* Getting max parameter.
	* @param first - first parameter
	* @param second - second parameter
	* @return max result
	*/
	public int max(int first, int second) {
		return (first > second) ? first : second;
	}

	/**
	* Getting maximum of three parameter.
	* @param first - first parameter
	* @param second - second parameter
	* @param third - third parameter
	* @return max result
	*/
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}