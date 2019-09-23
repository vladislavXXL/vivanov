package ru.job4j2.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class UserConvert.
 *
 * @author vivanov
 * @version 1
 * @since 23.09.2019
 */
public class UserConvert {

    /**
     * Class User.
     */
    public static class User {

        /** Field name.*/
        private final String name;

        /**
         * User constructor.
         *
         * @param name name value
         */
        public User(String name) {
            this.name = name;
        }

        /**
         * Getter method for name field.
         *
         * @return name value
         */
        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "User{" + "name='" + name + "\'" + "}";
        }
    }

    /**
     * Method to convert names into Users.
     *
     * @param names names values list
     * @param op functional interface
     * @return result users list
     */
    public List<User> convert(List<String> names, Function<String, User> op) {
        List<User> users = new ArrayList<>();
        names.forEach(n -> users.add(op.apply(n)));
        return users;
    }
}
