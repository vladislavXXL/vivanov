package ru.job4j2.tracker;

/**
 * Class BaseAction.
 * @author vivanov
 * @version 1
 * @since 12.11.2017
 */
public abstract class BaseAction implements UserAction {

    /** field action name. */
    private String name;

    /** field action key. */
    private int key;

    /**
     * Constructor of BaseAction.
     * @param name of action.
     * @param key of action.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * Method key to define action for execute.
     * @return key
     */
    @Override
    public abstract int key();

    /**
     * Method execute to run action.
     * @param input   - instance of class Input.
     * @param store - implementation of interface Store
     */
    @Override
    public abstract void execute(Input input, Store store);

    /**
     * Method info showing description of the operation to user.
     * @return result
     */
    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), this.name);
    }
}
