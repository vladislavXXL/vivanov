package ru.job4j2.tracker;

import java.util.List;

/**
 * Class StubInput.
 * @author vivanov
 * @version 1
 * @since 15.07.2017
 */
public class StubInput implements Input {

    /** Field array of answers. */
    private String[] answers;

    /** Field position index of current element in array of answers. */
    private int position = 0;

    /**
     * Constructor of class StubInput.
     * @param answers - array of answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Method ask to make console input.
     * @param question - ask user what operation to do
     * @return result of console input
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * Method ask to make console input with two parameters.
     * @param question - ask user what operation to do
     * @param ranges - to make sure input value belongs to this range
     * @return result of console input
     */
    public int ask(String question, List<Integer> ranges) {
        //throw new UnsupportedOperationException("Unsupported operation.");
        return -1;
    }

}
