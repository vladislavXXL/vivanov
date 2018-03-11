package ru.job4j2.collections.bank;

/**
 * Class Account.
 * @author vivanov
 * @version 1
 * @since 10.03.2018
 */
public class Account {

    /** Field value.*/
    private double value;

    /** Field requisites.*/
    private String requisites;

    /**
     * Class Account constructor.
     * @param value - amount of money
     * @param requisites - requisites
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Value getter.
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * Value setter.
     * @param value - money amount
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Requisites getter.
     * @return requisites
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * Requisites setter.
     * @param requisites - account requisites
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    /**
     * Method toString.
     * @return
     */
    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites='" + requisites + '\''
                + '}';
    }

    /**
     * Method equals.
     * @param o - object of class Account
     * @return result of comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    /**
     * Method hashCode.
     * @return result of hash operation
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }
}