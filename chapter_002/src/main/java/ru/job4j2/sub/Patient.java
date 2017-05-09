package ru.job4j2.sub;

/**
 * Class patient.
 * @author vivanov
 * @version 1
 * @since 08.05.2017
 */
public class Patient {

    /** Field patient name.*/
    private String name;

    /** Field patient last name.*/
    private String lastName;

    /** Field patient address.*/
    private String address;

    /** Name getter.
     * @return name
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

    /** Address getter.
     * @return address
     */
    public String getAddress() {
        return this.address;
    }
}
