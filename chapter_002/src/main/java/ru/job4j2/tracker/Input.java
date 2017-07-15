package ru.job4j2.tracker;

/**
 * Class Input.
 * @author vivanov
 * @version 1
 * @since 09.07.2017
 */
public interface Input {
    /**
     * Method ask to make console input.
     * @param question - ask user what operation to do
     * @return result of console input
     */
    String ask(String question);
}