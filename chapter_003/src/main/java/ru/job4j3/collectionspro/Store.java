package ru.job4j3.collectionspro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        /** result value.*/
        Info result = new Info();
        /** Edited users counter.*/
        int countEdited = 0;
        /** Deleted users counter.*/
        int countDeleted = 0;

        Map<Integer, String> mapcur = new HashMap<>();
        for (User user: current) {
            mapcur.put(user.getId(), user.getName());
        }

        for (User user: previous) {
            if (mapcur.containsKey(user.getId())) {
                if (!mapcur.get(user.getId()).equals(user.getName())) {
                    countEdited++;
                    mapcur.remove(user.getId());
                }
            } else {
                countDeleted++;
                mapcur.remove(user.getId());
            }
        }

        result.setNewUsers(mapcur.size());
        result.setEditedUsers(countEdited);
        result.setDeletedUsers(countDeleted);

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
            return this.newUsers;
        }

        /**
         * Edited users getter.
         * @return edited users quantity
         */
        public int getEditedUsers() {
            return this.editedUsers;
        }

        /**
         * Deleted users getter.
         * @return deleted users quantity
         */
        public int getDeletedUsers() {
            return this.deletedUsers;
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
         * Id getter.
         * @return id
         */
        public int getId() {
            return this.id;
        }

        /**
         * Name getter.
         * @return name
         */
        public String getName() {
            return this.name;
        }
    }
}
