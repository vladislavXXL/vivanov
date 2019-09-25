package ru.job4j2.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class CountFunctionInRangeTest used to test class CountFunctionInRange.
 *
 * @author vivanov
 * @version 1
 * @since 25.09.2019
 */
public class CountFunctionInRangeTest {

    /** Instance of CountFunctionRange.*/
    private CountFunctionInRange countFunction;

    /**
     * Initialization method.
     */
    @Before
    public void setUp() {
        this.countFunction = new CountFunctionInRange();
    }

    /**
     * Linear function.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = this.countFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Quadratic function.
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = this.countFunction.diapason(5, 8, x -> x * x + 8 * x + 3);
        List<Double> expected = Arrays.asList(68D, 87D, 108D);
        assertThat(result, is(expected));
    }

    /**
     * Logarithmic function.
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        List<Double> result = this.countFunction.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(1.609, 1.792, 1.946);
        assertThat(result, is(expected));
    }
}
