package ru.job4j3.threads.pool;

/**
 * Class Switcher.
 *
 * @author v.ivanov
 * @version 1
 * @since 28.04.2019
 */
public class Switcher {

    /** Filed value.*/
    private StringBuilder value;

    /**
     * Switcher constructor.
     *
     * @param line String value
     */
    public Switcher(String line) {
        this.value = new StringBuilder(line);
    }

    /**
     * Method to convert int value to String.
     *
     * @param num int value
     */
    public void addToString(int num) {
         this.value = this.value.append(String.valueOf(num));
    }

    /**
     * Field value getter.
     * @return value String
     */
    public String getValue() {
        return this.value.toString();
    }
}
