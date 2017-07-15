package ru.job4j2.tracker;

/**
 * Class StartUITest.
 * @author vivanov
 * @version 1
 * @since 15.07.2017
 */
public class StartUITest {

    /**
     * Method main to run execution of the program.
     * @param args - java key words and operators.
     */
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"Create stub task"});
        new StartUI(input).init();
    }
}
