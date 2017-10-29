package ru.job4j2.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 * @author vivanov
 * @version 1
 * @since 09.07.2017
 */
public class ConsoleInput implements Input {

    /** field scanner.*/
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method ask to make console input.
     * @param question - ask user what operation to do
     * @return result of console input
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Overloaded method ask to make console input with two parameters.
     * @param question - ask user what operation to do
     * @param ranges - to make sure input value belongs to this range
     * @return result of console input
     */
    public int ask(String question, int[] ranges) {
        int key = Integer.valueOf(this.ask(question));
        boolean isRange = false;
        for (int value : ranges) {
            if (value == key) {
                isRange = true;
                break;
            }
        }

        if (isRange) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }

}