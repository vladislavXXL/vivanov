package ru.job4j2.sub;

/**
 * Created by Вячесав on 09.05.2017.
 */
public class Student {

    /** Field student name.*/
    private String name;

    /** Field student last name.*/
    private String lastName;

    /** Field student class.*/
    private String studentClass;

    /** Field student iq.*/
    private int iq;

    /** Field parents phone number.*/
    private int phone;

    /** Name getter.
     * @return name - name
     */
    public String getName() {
        return this.name;
    }

    /** Last name getter.
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /** Student class getter.
     * @return student class
     */
    public String getStudentClass() {
        return this.studentClass;
    }

    /**
     * Student iq getter.
     * @return iq - iq
     */
    public int getIq() {
        return this.iq;
    }

    /**
     * Phone getter.
     * @return phone - parents phone number
     */
    public int getPhone() {
        return phone;
    }
}
