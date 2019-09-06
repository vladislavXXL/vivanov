package ru.job4j2.lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * CalculatorTest to test lambda calculator.
 *
 * @author vivanov
 * @version 1
 * @since 06.09.2019
 */
public class CalculatorTest {
    /**
     * Method to check class Calculator with lambda.
     */
    @Test
    public void whenAdd1Until3() {
       Calculator calc = new Calculator();
       List<Double> buffer = new ArrayList<>();
       calc.multiple(
               0, 3, 1,
               (value, index) -> (double) value + index, result -> buffer.add(result)
       );
        assertThat(buffer, is(Arrays.asList(1d, 2d, 3d)));
    }

}