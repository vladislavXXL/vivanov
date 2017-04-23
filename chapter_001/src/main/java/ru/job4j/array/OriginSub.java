package ru.job4j.array;

/**
* Class OriginSub to compare two String lines.
* @author vivanov
* @version 1
* @since 17.04.2017
*/

public class OriginSub {

	/**
	* Method contains() to compare two lines.
	* @param origin - first line.
	* @param sub - second line.
	* @return result.
	*/
	public boolean contains(String origin, String sub) {
        boolean result = false;
        int inc = 0;

        char[] ch1 = origin.toCharArray();
        char[] ch2 = sub.toCharArray();

        for (int i = 0; i <= ch1.length - ch2.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch2[j] == ch1[i + j]) {
                    inc++;
                } else {
                    j = ch2.length - 1;
                }
            }
            if (inc == ch2.length) {
                result = true;
            }
            inc = 0;
        }
        return result;
	}
}