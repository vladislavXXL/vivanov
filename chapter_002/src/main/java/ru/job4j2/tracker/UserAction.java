package ru.job4j2.tracker;

/**
 * Class UserAction.
 * @author vivanov
 * @version 1
 * @since 12.09.2017
 */

public interface UserAction {

    /**
     * Method key to define action for execute.
     * @return key
     */
    int key();

    /**
     * Method execute to run action.
     * @param input - instance of class Input.
     * @param store - implementation of interface Store
     */
    void execute(Input input, Store store);

    /**
     * Method info showing description of the operation to user.
     * @return result
     */
    String info();
}
