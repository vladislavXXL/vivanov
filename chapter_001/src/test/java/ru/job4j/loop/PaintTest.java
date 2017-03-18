package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Paint Test.
* @author vivanov
* @version 1
* @since 18.03.2017
*/

public class PaintTest {

	/**
	* Test with 2 lines piramid.
	*/
	@Test
	public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint obj = new Paint();
        String result = obj.piramid(2);
        String expected = String.format(" ^ %s^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }

	/**
	* Test with 3 lines piramid.
	*/
	@Test
	public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint obj = new Paint();
        String result = obj.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^", System.getProperty("line.separator"), System.getProperty("line.separator"));
        assertThat(result, is(expected));
	}
}