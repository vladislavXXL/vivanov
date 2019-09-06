package ru.job4j2.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Class Calculator to demonstrate lambda function.
 *
 * @author vivanov
 * @version 1
 * @since 06.09.2019
 */
public class Calculator {
    /**
     * Method multiple.
     * @param start start value
     * @param finish finish value
     * @param value value
     * @param op functional expression
     * @param media functional interface
     */
    public void multiple(int start, int finish, int value, BiFunction<Integer, Integer, Double> op, Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }
}
