package ru.job4j2.tracker;

/**
 * Class StartUI.
 * @author vivanov
 * @version 1
 * @since 09.07.2017
 */
public class StartUI {

    /** field instance of class Input. */
    private Input input;

    /** field tracker. */
    private Tracker tracker;

    /**
     * Class StartUI constructor.
     * @param input - instance of class Input.
     * @param tracker - instance of class Tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Method init to run class StartUI - main menu.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();

        /**
         * Anonymous class example.
         */
/*
        UserAction deleteAction = new UserAction() {
            public int key() {
                return 7;
            }

            public void execute(Input input, Tracker tracker) {
                //todo
            }
            public String info() {
                return  String.format("%s. %s", this.key(), "Delete the item");
            }
        };

        menu.addAction(deleteAction);
*/

        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.getRanges()));
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
    }

    /**
     * Method main to run execution of the program.
     * @param args - java key words and operators.
     */

    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }

}