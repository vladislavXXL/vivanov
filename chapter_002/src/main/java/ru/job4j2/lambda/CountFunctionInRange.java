package ru.job4j2.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Class CountFunctionInRange.
 *
 * @author vivanov
 * @version 1
 * @since 25.09.2019
 */
public class CountFunctionInRange {

    /**
     * Method to make calculation in the range.
     * @param start start range
     * @param end end range
     * @param func function to calculate
     * @return result list
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        IntStream.range(start, end).forEach(i -> {
                Double res = func.apply((double) i);
                result.add(Double.parseDouble(String.format("%.3f", res)));
        });
        return result;
    }
}
