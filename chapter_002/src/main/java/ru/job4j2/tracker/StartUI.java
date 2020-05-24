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
    private Store store;

    /**
     * @param input - instance of class Input.
     * Class StartUI constructor.
     * @param store - instance of class SqlTracker.
     */
    public StartUI(Input input, Store store) {
        this.input = input;
        this.store = store;
    }

    /**
     * Method init to run class StartUI - main menu.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.store);
        this.store.init();
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
                0return  String.format("%s. %s", this.key(), "Delete the item");
            }
        };

        menu.addAction(deleteAction);
*/

        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.getRanges()));
        } while (!"y".equals(this.input.ask("Exit? (y/n): ")));
    }

    /**
     * Method main to run execution of the program.
     * @param args - java key words and operators.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        try (Store store = new SqlTracker()) {
            new StartUI(input, store).init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}