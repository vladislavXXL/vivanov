package ru.job4j2.prof;
import ru.job4j2.sub.Student;

/**
 * Class Teacher.
 * @author vivanov
 * @version 1
 * @since 09.05.2017
 */
public class Teacher extends Profession {

    /** Field school number.*/
    private int schoolNumber;

    /** Field classes.*/
    private String[] classes = {"5а", "5б", "5в"};

    /**
     * Method teach student.
     * @param student - student
     * @return result after lesson
     */
    public String teachStudent(Student student) {
        return String.format("After lesson iq of the student %s %s is %d", student.getLastName(), student.getName(), student.getIq());
    }

    /**
     * Method to make call to the student's parents.
     * @param student - student
     * @return result line with the phone number
     */
    public String callParents(Student student) {
        return String.format("Parents phone number of student %s %s is %d ", student.getLastName(), student.getName(), student.getPhone());
    }
}