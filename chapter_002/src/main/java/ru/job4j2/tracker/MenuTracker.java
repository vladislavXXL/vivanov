package ru.job4j2.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MenuTracker.
 * @author vivanov
 * @version 1
 * @since 12.09.2017
 */
class EditItem extends BaseAction {

    /**
     * Constuctor of EditItem class.
     * @param name of action.
     * @param key of action.
     */
    EditItem(String name, int key) {
        super(name, key);
    }

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
    private List<UserAction> actions = new ArrayList<UserAction>();

    /** Field ranges contains keys of menu for switch the operation. */
    private List<Integer> ranges = new ArrayList<Integer>();

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
        this.actions.add(this.new AddItem("Add item", 0));
        this.actions.add(new MenuTracker.ShowItems("Show item", 1));
        this.actions.add(new EditItem("Edit item", 2));
        this.actions.add(this.new DeleteItem("Delete item", 3));
        this.actions.add(this.new FindById("Find by ID", 4));
        this.actions.add(this.new FindByName("Find by name", 5));
        this.actions.add(this.new Exit("Exit", 6));

        for (int i = 0; i < this.actions.size(); i++) {
            this.ranges.add(i);
        }
    }

    /**
     * Method to add new action.
     * @param action - action to add.
     */
    public void addAction(UserAction action) {
        this.actions.add(action);
    }

    /**
     * Getter to get available keys of menu.
     * @return field ranges
     */
    public List<Integer> getRanges() {
        return this.ranges;
    }

    /**
     * Method to select action and run it's execution.
     * @param key - action id.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
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
    private class AddItem extends BaseAction {

        /**
         * Constructor of AddItem class.
         * @param name of action.
         * @param key of action.
         */
        AddItem(String name, int key) {
            super(name, key);
        }

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
    }

    /** Class ShowItems. */
    private static class ShowItems extends BaseAction {

        /**
         * Constructor of class ShowItems.
         * @param name of action.
         * @param key of action.
         */
        ShowItems(String name, int key) {
            super(name, key);
        }

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
            for (Item item: tracker.getAll()) {
                System.out.println(
                        String.format("%s. %s. %s.", item.getId(), item.getName(), item.getDesc())
                );
            }
        }
    }
    /** Class DeleteItem. */
    private class DeleteItem extends BaseAction {

        /**
         * Constuctor of DeleteItem class.
         * @param name of action.
         * @param key of action.
         */
        DeleteItem(String name, int key) {
            super(name, key);
        }

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
    }
    /** Class FindById. */
    private class FindById extends BaseAction {

        /**
         * Constructor of FindById class.
         * @param name of action.
         * @param key of action.
         */
        FindById(String name, int key) {
            super(name, key);
        }

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
    }

    /** Class FindByName. */
    private class FindByName extends BaseAction {

        /**
         * Constructor of FindByName class.
         * @param name of action.
         * @param key of action.
         */
        FindByName(String name, int key) {
            super(name, key);
        }

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
            List<Item> result = tracker.findByName(name);
            for (Item el : result) {
                System.out.println(
                        String.format("id: %s; name: %s; description: %s;", el.getId(), el.getName(), el.getDesc())
                );
            }
        }
    }
    /** Class Exit. */
    private class Exit extends BaseAction {

        /**
         * Constructor of Exit class.
         * @param name of action.
         * @param key of action.
         */
        Exit(String name, int key) {
            super(name, key);
        }

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
    }
}