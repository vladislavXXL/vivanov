package ru.job4j2.lambda;

import java.util.Objects;

/**
 * Class Student.
 *
 * @author v.ivanov
 * @version 1
 * @since 30.10.2019
 */
public class Student {

    /** Field student's name.*/
    private String name;

    /** Field score value from 0 to 100.*/
    private int score;

    /**
     * Class Student constructor.
     *
     * @param name student's name value
     * @param score student's score value
     */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Getter for score field.
     *
     * @return score field value
     */
    public int getScore() {
        return score;
    }

    /**
     * Override equals method for Student class.
     *
     * @param o student instance
     * @return result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score && Objects.equals(name, student.name);
    }

    /**
     * Override hashCode method for Student class.
     *
     * @return int hashCode value
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
