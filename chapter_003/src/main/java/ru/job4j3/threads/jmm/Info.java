package ru.job4j3.threads.jmm;

/**
 * Class Info contains some information.
 * @author v.ivanov
 * @version 1
 * @since 16.12.2018
 */
public class Info {

    /** Field key.*/
    private int key;

    /**
     * Class Info constructor.
     * @param key value
     */
    public Info(int key) {
        this.key = key;
    }

    /**
     * Getter key.
     * @return key value
     */
    public int getKey() {
        return key;
    }

    /**
     * Setter key.
     * @param key value
     */
    public void setKey(int key) {
        this.key = key;
    }
}
