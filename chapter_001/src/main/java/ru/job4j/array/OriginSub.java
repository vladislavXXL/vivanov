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
        int inc = 1;
        char[] ch1 = new char[origin.length()];
        char[] ch2 = new char[sub.length()];
        for (int i = 0; i < origin.length(); i++) {
            ch1[i] = origin.charAt(i);
        }
        for (int i = 0; i < sub.length(); i++) {
            ch2[i] = sub.charAt(i);
        }
        int i = 1;
        int j = 1;
        while (i < ch1.length && j < ch2.length) {
            if (ch1[i - 1] == ch2[j - 1] && ch1[i] == ch2[j]) {
                inc++;
                j++;
            }
            i++;
        }
        if (inc == ch2.length) {
            result = true;
        }
	return result;
	}
}