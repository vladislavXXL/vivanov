package ru.job4j2.lambda;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SchoolTest to test School class.
 *
 * @author v.ivanov
 * @version 1
 * @since 30.10.2019
 */
public class SchoolTest {

    /**
     * Field School instance.
     */
    private static School school;

    /**
     * Field Students list.
     */
    private static List<Student> students;

    /**
     * Mehtode to initialize SchoolTest class field.
     */
    @BeforeClass
    public static void setUp() {
        school = new School();
        students = Arrays.asList(
                new Student("Ivanov Maxim", 71),
                new Student("Petrov Dmitriy", 32),
                new Student("Sidorov Vetaliy", 100),
                new Student("Kuznecov Vladimir", 99),
                new Student("Goncharov Iliya", 15),
                new Student("Samsonov Sergei", 51),
                new Student("Gribov Anatoliy", 65),
                new Student("Burunov Roman", 43),
                new Student("Egorov Egor", 21),
                new Student("Sergeev Anton", 79),
                new Student("Demidov Demid", 69),
                new Student("Kapustin Konstantin", 86)
        );
    }

    /**
     * Method to collect students into 10A class.
     */
    @Test
    public void testCollectStudentsTo10A() {
        List<Student> expectedList = Arrays.asList(
                new Student("Ivanov Maxim", 71),
                new Student("Sidorov Vetaliy", 100),
                new Student("Kuznecov Vladimir", 99),
                new Student("Sergeev Anton", 79),
                new Student("Kapustin Konstantin", 86)
        );
        List<Student> actualList = school.collect(students, student -> student.getScore() >= 70 && student.getScore() <= 100);
        assertThat(actualList, is(expectedList));
    }

    /**
     * Method to collect students into 10B class.
     */
    @Test
    public void testCollectStudentsTo10B() {
        List<Student> expectedList = Arrays.asList(
                new Student("Samsonov Sergei", 51),
                new Student("Gribov Anatoliy", 65),
                new Student("Demidov Demid", 69)
        );
        List<Student> actualList = school.collect(students, student -> student.getScore() >= 50 && student.getScore() <= 70);
        assertThat(actualList, is(expectedList));
    }

    /**
     * Method to collect students into 10C class.
     */
    @Test
    public void testCollectStudentsTo10C() {
        List<Student> expectedList = Arrays.asList(
                new Student("Petrov Dmitriy", 32),
                new Student("Goncharov Iliya", 15),
                new Student("Burunov Roman", 43),
                new Student("Egorov Egor", 21)
        );
        List<Student> actualList = school.collect(students, student -> student.getScore() >= 0 && student.getScore() <= 50);
        assertThat(actualList, is(expectedList));
    }
}