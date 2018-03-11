package ru.job4j2.collections.bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Class BankTest.
 * @author vivanov
 * @version 1
 * @since 10.03.2018
 */
public class BankTest {

    /**
     * Method to test adding a new user.
     */
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User ivanov = new User("Ivanov Ivan Ivanovich", "123xxx45");
        bank.addUser(ivanov);

        Map<User, List<Account>> map = bank.getUserAccountsMap();
        assertThat(true, equalTo(map.containsKey(ivanov)));
    }

    /**
     * Method to test deleteUser operation from bank.
     */
    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();

        /** Add first user.*/
        User ivanov = new User("Ivanov Ivan Ivanovich", "123xxx45");
        bank.addUser(ivanov);

        /** Add second user.*/
        User petrov = new User("Petrov Petr Petrovich", "777xyz777");
        bank.addUser(petrov);

        /** Get users.*/
        Map<User, List<Account>> map = bank.getUserAccountsMap();

        /** Delete first user.*/
        bank.deleteUser(ivanov);

        /** Check if user ivanov is removed.*/
        assertThat(null, equalTo(map.get(ivanov)));
    }

    /**
     * Method to test adding new account to user.
     */
    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();

        /** Add user.*/
        User ivanov = new User("Ivanov Ivan Ivanovich", "123xxx45");
        bank.addUser(ivanov);
        bank.addAccountToUser("123xxx45", new Account(5000, "RUR123xxx45"));

        Map<User, List<Account>> map = bank.getUserAccountsMap();
        assertThat(map.get(ivanov).get(0), equalTo(new Account(5000, "RUR123xxx45")));

    }

    /**
     * Method to delete account from user.
     */
    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank();

        /** Add user.*/
        User ivanov = new User("Ivanov Ivan Ivanovich", "123xxx45");
        bank.addUser(ivanov);
        bank.addAccountToUser("123xxx45", new Account(5000, "RUR123xxx45"));
        bank.addAccountToUser("123xxx45", new Account(1000, "EUR123xxx45"));

        bank.deleteAccountFromUser("123xxx45", new Account(5000, "RUR123xxx45"));
        Map<User, List<Account>> map = bank.getUserAccountsMap();

        assertThat(map.get(ivanov).get(0), equalTo(new Account(1000, "EUR123xxx45")));
    }

    /**
     * Method to test getting all the user's account.
     */
    @Test
    public void whenGetUserAccounts() {
        Bank bank = new Bank();

        /** Add user.*/
        User ivanov = new User("Ivanov Ivan Ivanovich", "123xxx45");
        bank.addUser(ivanov);
        bank.addAccountToUser("123xxx45", new Account(50000, "RUR123xxx45"));
        bank.addAccountToUser("123xxx45", new Account(1000, "EUR123xxx45"));
        bank.addAccountToUser("123xxx45", new Account(3000, "USD123xxx45"));

        Map<User, List<Account>> map = bank.getUserAccountsMap();

        assertThat(map.get(ivanov), equalTo(Arrays.asList(
                new Account(50000, "RUR123xxx45"),
                new Account(1000, "EUR123xxx45"),
                new Account(3000, "USD123xxx45")
        )));
    }

    /**
     * Method to make money transfer to another account.
     */
    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();

        /** Add user sender.*/
        User ivanov = new User("Ivanov Ivan Ivanovich", "123xxx45");
        bank.addUser(ivanov);
        bank.addAccountToUser("123xxx45", new Account(50000, "RUR123xxx45"));

        /** Add user reciever.*/
        User petrov = new User("Petrov Petr Petrovich", "777xyz777");
        bank.addUser(petrov);
        bank.addAccountToUser("777xyz777", new Account(2500, "EUR777xyz777"));
        bank.addAccountToUser("777xyz777", new Account(10000, "RUR777xyz777"));

        Map<User, List<Account>> map = bank.getUserAccountsMap();

        bank.transferMoney("123xxx45", "RUR123xxx45", "777xyz777", "RUR777xyz777", 25000);

        assertThat(map.get(petrov).get(1).getValue(), is(35000.0));
    }
}