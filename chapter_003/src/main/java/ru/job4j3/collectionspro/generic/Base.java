package ru.job4j3.collectionspro.generic;

/**
 * @author vivanov
 * @version 1
 * @since 13.05.2018
 */
public abstract class Base {

    /** Field id.*/
    private final String id;

    /**
     * Class Base constructor.
     * @param id id
     */
    protected Base(String id) {
        this.id = id;
    }

    /**
     * Field id getter.
     * @return id
     */
    public String getId() {
        return this.id;
    }
}
