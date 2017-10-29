package ru.job4j2.tracker;

/**
 * Class MenuOutException.
 * @author vivanov
 * @version 1
 * @since 29.10.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     * Class MenuOutException constructor.
     * @param msg - message to print when exception occurred
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}