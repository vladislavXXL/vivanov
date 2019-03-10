package ru.job4j3.threads.pool;

/**
 * Class User.
 *
 * @author v.ivanov
 * @version 1
 * @since 10.03.2019
 */
public class User {

    /** Field user name.*/
    private String username;

    /** Field user mail.*/
    private String email;

    /**
     * Class User constructor.
     *
     * @param username user name value
     * @param email user email value
     */
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * User name getter.
     *
     * @return result user name value
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * User email getter.
     *
     * @return user email value
     */
    public String getEmail() {
        return this.email;
    }
}
