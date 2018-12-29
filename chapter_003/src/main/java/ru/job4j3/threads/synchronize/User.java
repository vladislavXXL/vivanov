package ru.job4j3.threads.synchronize;

/**
 * Class User.
 * @author v.ivanov
 * @version 1
 * @since 24.12.2018
 */
public class User {

    /** Field user id.*/
    private int id;

    /** Field balance amount.*/
    private int amount;

    /**
     * Common User constructor.
     * @param id user id
     */
    public User(int id) {
        this.id = id;
        this.amount = 0;
    }

    /**
     * Class User constructor.
     * @param id user id.
     * @param amount user balance
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Id getter.
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Id setter
     * @param id value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Amount getter.
     * @return amount value
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Amount setter.
     * @param amount value of amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
