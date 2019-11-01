package ru.job4j2.lambda;

/**
 * Class Address.
 *
 * @author v.ivanov
 * @version 1
 * @since 31.10.2019
 */
public class Address {

    /** Field city.*/
    private String city;

    /** Field street.*/
    private String street;

    /** Field home.*/
    private int home;

    /** Field apartment.*/
    private int apartment;

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }
}
