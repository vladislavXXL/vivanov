package ru.job4j3.threads.synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class UserStorage describes users transactions.
 * @author v.ivanov
 * @version 1
 * @since 24.12.2018
 * @param <T> type parameter
 */
@ThreadSafe
public class UserStorage<T extends User> {

    /** Field to add and save users.*/
    @GuardedBy("this")
    private Set<T> storage;

    /**
     * Method to get storage with users.
     * @return set of users
     */
    public synchronized Set<T> getStorage() {
        return this.storage;
    }

    /**
     * Constructor of UserStorage class.
     * @param storage list of users to add into the storage
     */
    public UserStorage(List<T> storage) {
        this.storage = new HashSet<>(storage);
    }

    /**
     * Method to add new user to the storage.
     * @param user user to add.
     * @return result of the operation
     */
    public synchronized boolean add(T user) {
        return this.storage.add(user);
    }

    /**
     * Method to get user's balance amount by user id.
     * @param id user id
     * @return amount value
     */
    public synchronized int getAmountById(int id) {
        int[] arr = this.storage.stream()
                .filter(e -> e.getId() == id)
                .mapToInt(e -> e.getAmount())
                .toArray();
        return arr[0];
    }

    /**
     * Method to update user info.
     * @param user to update
     * @return result of the operation
     * @throws Exception exception with message
     */
    public synchronized boolean update(T user) throws Exception {
        Set<T> toUpdate = this.storage.stream()
                .filter(e -> e.getId() == user.getId())
                .collect(Collectors.toSet());
        toUpdate.forEach(e -> e.setAmount(user.getAmount()));
        boolean result = toUpdate.size() > 0;
        if (!result) {
            throw new Exception("User with id " + user.getId() + " is not presented in the storage.");
        }
        return result;
    }

    /**
     * Method to remove user from storage.
     * @param user - user to remove
     * @return result of the operation
     */
    public synchronized boolean delete(T user) {
        return this.storage.remove(user);
    }

    /**
     * Method used to make transfers between two users.
     * @param fromId first user
     * @param toId second user
     * @param amount amount to transfer
     * @throws Exception exception with message
     */
    public synchronized void transfer(int fromId, int toId, int amount) throws Exception {
        Set<T> setIds = this.storage.stream()
                .filter(e -> e.getId() == fromId || e.getId() == toId)
                .collect(Collectors.toSet());
        if (setIds.size() == 2) {
            for (T user: this.storage) {
                if (user.getId() == fromId) {
                    user.setAmount(user.getAmount() - amount);
                }
                if (user.getId() == toId) {
                    user.setAmount(user.getAmount() + amount);
                }
            }
        } else {
            throw new Exception("You have entered wrong user's id values.");
        }
    }
}
