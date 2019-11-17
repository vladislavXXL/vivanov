package ru.job4j2.lambda;

import java.util.Objects;

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

    /**
     * Address params constructor.
     *
     * @param city city value
     * @param street street value
     * @param home home value
     * @param apartment apartment value
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    /** Field city getter.
     *
     * @return city value
     */
    public String getCity() {
        return city;
    }

    /**
     * Method toString.
     *
     * @return toString method result
     */
    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }

    /**
     * Mehtod equals.
     *
     * @param o another object
     * @return result of method equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && city.equals(address.city)
                && street.equals(address.street);
    }

    /**
     * Method hashCode.
     *
     * @return result of hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
