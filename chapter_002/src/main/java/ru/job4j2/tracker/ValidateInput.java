package ru.job4j2.tracker;

import java.util.List;

/**
 * Class ValidateInput to check input parameters.
 * @author vivanov
 * @since 10.10.2017
 * @version 1
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Method ask to make console input with two parameters.
     * @param question - asking user what operation to do
     * @param ranges - to make sure input value belongs to this range
     * @return result to run menu or run exception handler
     */
    public int ask(String question, List<Integer> ranges) {
        boolean notValid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, ranges);
                notValid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select a key from the menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (notValid);
        return value;
    }
}