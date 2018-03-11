package ru.job4j2.collections.bank;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Bank.
 * @author vivanov
 * @version 1
 * @since 10.03.2018
 */
public class Bank {

    /** Field treeMap with user and his banking accounts.*/
    private Map<User, List<Account>> userAccountsMap = new TreeMap<>();

    /**
     * Method getter of field userAccountsMap.
     * @return user's list of accounts
     */
    public Map<User, List<Account>> getUserAccountsMap() {
        return this.userAccountsMap;
    }

    /**
     * Method to add new User and his accounts.
     * @param user - user to add
     */
    public void addUser(User user) {
        this.userAccountsMap.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Method to delete User and his accounts from Bank.
     * @param user to delete
     */
    public void deleteUser(User user) {
        this.userAccountsMap.remove(user);
    }

    /**
     * Method to add new acccount for defined user by passport.
     * @param passport - user id
     * @param account - user account
     */
    public void addAccountToUser(String passport, Account account) {
        Iterator<Map.Entry<User, List<Account>>> itr = this.userAccountsMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<User, List<Account>> values = itr.next();
            if (values.getKey().getPassport().equals(passport)) {
                this.userAccountsMap.get(values.getKey()).add(account);
            }
        }
    }

    /**
     * Method to delete one of account from the user.
     * @param passport of user
     * @param account of user
     */
    public void deleteAccountFromUser(String passport, Account account) {
        Iterator<Map.Entry<User, List<Account>>> itr = this.userAccountsMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<User, List<Account>> values = itr.next();
            if (values.getKey().getPassport().equals(passport)) {
                this.userAccountsMap.get(values.getKey()).remove(account);
            }
        }
    }

    /**
     * Method to get all the accounts of defined user by passport.
     * @param passport of user
     * @return result list user's accounts
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<Account>();

        Iterator<Map.Entry<User, List<Account>>> itr = this.userAccountsMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<User, List<Account>> values = itr.next();
            if (values.getKey().getPassport().equals(passport)) {
                result = values.getValue();
            }
        }
        return result;
    }

    /**
     * Method to make transfer.
     * @param srcPassport - sender user's passport
     * @param srcRequisites - sender user's requisites
     * @param destPassport - reciever user's passport
     * @param destRequisites - reciever user's requisites
     * @param amount - amount of money to send
     * @return operation status
     */
    public boolean transferMoney(String srcPassport, String srcRequisites, String destPassport, String destRequisites, double amount) {
        boolean result = false;
        List<Account> srcList = new ArrayList<>();
        List<Account> destList = new ArrayList<>();

        Iterator<Map.Entry<User, List<Account>>> itr = userAccountsMap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<User, List<Account>> values = itr.next();
            if (values.getKey().getPassport().equals(srcPassport)) {
                srcList = values.getValue();
            }
            if (values.getKey().getPassport().equals(destPassport)) {
                destList = values.getValue();
            }
        }

        /** Check if destRequisites are available for this destPassport.*/
        boolean isRequisites = false;
        int index = 0;
        for (Account el: destList) {
            isRequisites = el.getRequisites().equals(destRequisites) ? true : false;
            if (el.getRequisites().equals(destRequisites)) {
                isRequisites = true;
                index = destList.indexOf(el);
                break;
            }
        }

        for (Account el: srcList) {
            if (el.getRequisites().equals(srcRequisites) && el.getValue() >= amount && isRequisites) {
                el.setValue(el.getValue() - amount);
                destList.get(index).setValue(destList.get(index).getValue() + amount);
                result = true;
                break;
            }
        }

        return result;
    }
}