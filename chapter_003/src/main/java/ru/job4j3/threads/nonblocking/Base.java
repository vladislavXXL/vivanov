package ru.job4j3.threads.nonblocking;

/**
 * Class Base.
 *
 * @author v.ivanov
 * @version 1
 * @since 23.02.2019
 */
public class Base {

    /** Field id.*/
    private final int id;

    /** Field name.*/
    private String name;

    /** Field to check changes.*/
    private volatile int version = 0;

    /**
     * Base constructor.
     *
     * @param id int value
     * @param name String value
     */
    public Base(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Field Id getter method.
     *
     * @return id int value
     */
    public int getId() {
        return this.id;
    }

    /**
     * Field id getter method.
     *
     * @return name String value
     */
    public String getName() {
        return this.name;
    }

    /**
     * Field version getter method.
     *
     * @return version int value
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Field version increment method.
     */
    public void incVersion() {
        this.version++;
    }

    /**
     * Field name setter method.
     * @param name set String value
     */
    public void setName(String name) {
        this.name = name;
    }
}
