package ru.job4j2.coffeemachine;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ChangeTest to test class Change.
 * @author vivanov
 * @version 1
 * @since 06.01.2018
 */

public class ChangeTest {

    /**
     * Method is used to test value and amount of notes giving from coffe machine.
     */
    @Test
    public void whenCheckCoffeeMachineChangeBack() {

        Change obj = new Change();
        int[] arr = obj.changes(50, 35);
        assertThat(arr[0], is(10));
        assertThat(arr[1], is(5));

        int[] arr2 = obj.changes(54, 35);
        assertThat(arr2[0], is(10));
        assertThat(arr2[1], is(5));
        assertThat(arr2[2], is(2));
        assertThat(arr2[3], is(2));
    }
}
