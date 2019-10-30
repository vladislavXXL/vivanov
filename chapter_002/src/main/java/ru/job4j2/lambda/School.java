package ru.job4j2.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class School.
 *
 * @author v.ivanov
 * @version 1
 * @since 30.10.2019
 */
public class School {

    /**
     * Method to collect student by their score value.
     *
     * @param students list of students
     * @param predicate condition to filter
     * @return result list of students
     */
    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
