package ru.job4j2.collections.comparator;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test ListCompare.
 * @author vivanov
 * @version 1
 * @since 26.02.2018
 */
public class ListCompareTest {

    /**
     * Method to test when lists are equals to each over.
     */
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(0));
    }

    /**
     * Method to test when element from left list is less than element from right list.
     */
    @Test
    public void whenLeftLessRightThenMinus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(-1));
    }

    /**
     * Method to test when element from left list is greater than element from right list.
     */
    @Test
    public void whenLeftGreatThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2),
                Arrays.asList(1, 1)
        );
        assertThat(rst, is(1));
    }
}
