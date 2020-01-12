package ru.job4j2.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to check Stream API.
 *
 * @author v.ivanov
 * @version 1
 * @since 12.01.2020
 *
 * @param <T> type parameter
 */
public class LambdaUtils<T> {

    /**
     * Method to convert matrix to list.
     *
     * @param matrix to convert
     * @return result list
     */
    public List<T> convertMatrixToList(T[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
