package ru.job4j.loop;

/**
* Class paint.
* @author vivanov
* @version 1
* @since 14.03.2017
*/

public class Paint {

	/**
	* @param h - height of a piramid.
	* @return result
	*/
	 public String piramid(int h) {
		int half = (int) Math.ceil((2.0 * h - 1.0) / 2.0) - 1;
		int elemTotal = 2 * h - 1;
		StringBuilder str = new StringBuilder();
		int pos = 0; //spaces position range
		int elem = 0; //spaces amount in the current line
		for (int i = 1; i <= h; i++) {
			elem = 2 * i - 1;
			pos = (elemTotal - elem) / 2;
			for (int j = 1; j <= elemTotal; j++) {
				if (j <= pos || j >= pos + elem + 1) {
					str.append(' ');
					if (j % elemTotal == 0) {
						str.append(System.getProperty("line.separator"));
					}
				} else {
					str.append('^');
				}
			}
		}
		String strResult = str.toString();
		return strResult;
	}
}