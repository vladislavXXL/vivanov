package ru.job4j2.tracker;

import java.util.List;

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


    /**
     * Method ask is used to make console input with two parameters: quastion and range to make sure input value belongs to it.
     * @param question - ask user what operation to do
     * @param range - to make sure input value belongs to this range
     * @return result of console input
     */
    int ask(String question, List<Integer> range);
}