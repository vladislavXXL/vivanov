package ru.job4j3.collectionspro;

import java.util.List;

/**
 * Class Store.
 * @author v.ivanov
 * @version 1
 * @since 07.10.2018
 */
public class Store {

    /**
     * Method to get information about changes in collection of users.
     * @param previous list
     * @param current list
     * @return class Info with statistics
     */
    Info diff(List<User> previous, List<User> current) {
        Info result = new Info();

        /** Get new users.*/
        int countNew = 0;
        for (User el: current) {
            if (!previous.contains(el)) {
                countNew++;
            }
        }
        result.setNewUsers(countNew);

        /** Get edited users.*/
        int countEdit = 0;
        int index = 0;
        for (User el: current) {
            if (previous.contains(el) && !el.getName().equals(previous.get(index).getName())) {
                countEdit++;
            }
            index++;
        }
        result.setEditedUsers(countEdit);

        /** Get deleted users.*/
        int countDel = 0;
        for (User el: previous) {
            if (!current.contains(el)) {
                countDel++;
            }
        }
        result.setDeletedUsers(countDel);
        return result;
    }

    /**
     * Class info.
     * @author v.ivanov
     * @version 1
     * @since 14.10.2018
     */
    class Info {
        /** Field the quantity of a new users.*/
        private int newUsers;

        /** Field the quantity of a edited users.*/
        private int editedUsers;

        /** Field the quantity of a deleted users.*/
        private int deletedUsers;

        /**
         * New users getter.
         * @return new users quantity
         */
        public int getNewUsers() {
            return newUsers;
        }

        /**
         * Edited users getter.
         * @return edited users quantity
         */
        public int getEditedUsers() {
            return editedUsers;
        }

        /**
         * Deleted users getter.
         * @return deleted users quantity
         */
        public int getDeletedUsers() {
            return deletedUsers;
        }

        /**
         * New users setter.
         * @param newUsers set new users quantity
         */
        public void setNewUsers(int newUsers) {
            this.newUsers = newUsers;
        }

        /**
         * Edited users setter.
         * @param editedUsers set edited users quantity
         */
        public void setEditedUsers(int editedUsers) {
            this.editedUsers = editedUsers;
        }

        /**
         * Deleted users setter.
         * @param deletedUsers set deleted users quantity
         */
        public void setDeletedUsers(int deletedUsers) {
            this.deletedUsers = deletedUsers;
        }
    }

    /**
     * Class User.
     * @author v.ivanov
     * @version 1
     * @since 14.10.2018
     */
    static class User {
        /** User's id.*/
        private int id;

        /** User's name.*/
        private String name;

        /**
         * Class User constructor.
         * @param id user's id
         * @param name user's name
         */
        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * Method equals override.
         * @param o
         * @return result
         */
/*
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (id != user.id) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }
*/

        @Override
        public boolean equals(Object o) {
            boolean result = false;
            if (this == o && o != null && getClass() == o.getClass())  {
                result = true;
            }

            User user = (User) o;

            if (id == user.id) {
                result = true;
            }
            return result;
        }

        /**
         * Method hashCode override.
         * @return result
         */
        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        /**
         * Id getter.
         * @return id
         */
        public int getId() {
            return id;
        }

        /**
         * Name getter.
         * @return name
         */
        public String getName() {
            return name;
        }
    }
}
