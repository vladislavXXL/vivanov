package ru.job4j2.lambda;

/**
 * Class Profile.
 *
 * @author v.ivanov
 * @version 1
 * @since 31.10.2019
 */
public class Profile {

    /** Field name.*/
    private String name;

    /** Field Profile's address.*/
    private Address address;

    /**
     * Class Profile constructor.
     *
     * @param name field name value
     * @param address field address value
     */
    public Profile(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Field address getter method.
     *
     * @return address value
     */
    public Address getAddress() {
        return address;
    }
}
