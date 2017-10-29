package ru.job4j2.tracker;

/**
 * Class MenuTracker.
 * @author vivanov
 * @version 1
 * @since 12.09.2017
 */

class EditItem implements UserAction {

    /**
     * Method key returns action id.
     * @return result
     */
    public int key() {
        return 2;
    }

    /**
     * Method execute to run action of edit the item.
     * @param input - instance of class Input.
     * @param tracker - instance of class Tracker.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter the item's id:");
        String name = input.ask("Please enter the items's name:");
        String desc = input.ask("Please enter the item's description");
        long created = System.currentTimeMillis();
        Item item = new Item(id, name, desc, created);
        tracker.update(item);
    }

    /**
     * Method info returns the name and id of user action.
     * @return result
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the item.");
    }
}

/**
 * Class MenuTracker.
 */
public class MenuTracker {

    /** Field instance of class Input. */
    private Input input;

    /** Field instance of class Tracker. */
    private Tracker tracker;

    /** Field array of all available user actions. */
    private UserAction[] actions = new UserAction[7];

    /** Field ranges contains keys of menu for switch the operation. */
    private int[] ranges = new int[this.actions.length];

    /**
     * Class MenuTracker constructor.
     * @param input - instance of class Input.
     * @param tracker - instance of class Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /** Method to fill fields array actions and array ranges contains the keys of menu. */
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindById();
        this.actions[5] = this.new FindByName();
        this.actions[6] = this.new Exit();

        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
    }

    /**
     * Getter to get available keys of menu.
     * @return field ranges
     */
    public int[] getRanges() {
        return this.ranges;
    }

    /**
     * Method to select action and run it's execution.
     * @param key - action id.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /** Method to show all available user actions. */
    public void show() {
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /** Class AddItem. */
    private class AddItem implements UserAction {

        /**
         * Method key returns action id.
         * @return result
         */
        public int key() {
            return 0;
        }

        /**
         * Method execute to run action of add the item.
         * @param input - instance of class Input.
         * @param tracker - instance of class Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the item's id:");
            String name = input.ask("Please enter the items's name:");
            String desc = input.ask("Please enter the item's description");
            long created = System.currentTimeMillis();
            Item item = new Item(id, name, desc, created);
            tracker.add(item);
        }

        /**
         * Method info returns the name and id of user action.
         * @return result
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /** Class ShowItems. */
    private static class ShowItems implements UserAction {

        /**
         * Method key returns action id.
         * @return result
         */
        public int key() {
            return  1;
        }

        /**
         * Method execute to run action of show items.
         * @param input - instance of class Input.
         * @param tracker - instance of class Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item: tracker.findAll()) {
                System.out.println(
                        String.format("%s. %s. %s.", item.getId(), item.getName(), item.getDesc())
                );
            }
        }

        /**
         * Method info returns the name and id of user action.
         * @return result
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }

    }
    /** Class DeleteItem. */
    private class DeleteItem implements UserAction {

        /**
         * Method key returns action id.
         * @return result
         */
        public int key() {
            return 3;
        }

        /**
         * Method execute to run action of delete item.
         * @param input - instance of class Input.
         * @param tracker - instance of class Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the item's id:");
            String name = input.ask("Please enter the items's name:");
            String desc = input.ask("Please enter the item's description");
            long created = System.currentTimeMillis();
            Item item = new Item(id, name, desc, created);
            tracker.delete(item);
        }

        /**
         * Method info returns the name and id of user action.
         * @return result
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item.");
        }

    }
    /** Class FindById. */
    private class FindById implements UserAction {

        /**
         * Method key returns action id.
         * @return result
         */
        public int key() {
            return 4;
        }

        /**
         * Method execute to run action of find by id.
         * @param input - instance of class Input.
         * @param tracker - instance of class Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the item's id:");
            Item result = tracker.findById(id);
            System.out.println(
                    String.format("id: %s; name: %s; description: %s;", result.getId(), result.getName(), result.getDesc())
            );
        }

        /**
         * Method info returns the name and id of user action.
         * @return result
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find the item by ID.");
        }
    }

    /** Class FindByName. */
    private class FindByName implements UserAction {

        /**
         * Method key returns action id.
         * @return result
         */
        public int key() {
            return 5;
        }

        /**
         * Method execute to run action of find item by name.
         * @param input - instance of class Input.
         * @param tracker - instance of class Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the item's name:");
            Item[] result = tracker.findByName(name);
            for (Item el : result) {
                System.out.println(
                        String.format("id: %s; name: %s; description: %s;", el.getId(), el.getName(), el.getDesc())
                );
            }
        }

        /**
         * Method info returns the name and id of user action.
         * @return result
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
        }
    }
    /** Class Exit. */
    private class Exit implements UserAction {

        /**
         * Method key returns action id.
         * @return result
         */
        public int key() {
            return  6;
        }

        /**
         * Method execute to run action of program exit.
         * @param input - instance of class Input.
         * @param tracker - instance of class Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("Press 'y' to exit the program");
        }

        /**
         * Method info returns the name and id of user action.
         * @return result
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}