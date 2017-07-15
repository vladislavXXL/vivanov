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

    /** field menu - displays available operations to run. */
    private String[] menu = {
            "0. Add new item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by id",
            "5. Find items by name",
            "6. Exit Program"
    };

    /**
     * Class StartUI constructor.
     * @param input - instance of class Input.
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Method to show available operations.
     */
    public void showStartMenu() {
        for (String el : this.menu) {
            System.out.println(el);
        }
    }

    /**
     * Method init to run class StartUI - main menu.
     */
    public void init() {
        Tracker tracker = new Tracker();
        boolean bQuit = false;
        while (!bQuit) {
            showStartMenu();
            String request = input.ask("Select: ");
            int iRequest = Integer.valueOf(request);
            if (iRequest == 6) {
                bQuit = true;
            } else if (iRequest == 0) {
                String id = input.ask("Please enter the item's id:");
                String name = input.ask("Please enter the items's name:");
                String desc = input.ask("Please enter the item's description");
                long created = System.currentTimeMillis();
                Item item = new Item(id, name, desc, created);
                tracker.add(item);
            } else if (iRequest == 1) {
                Item[] result = tracker.findAll();
                for (Item el : result) {
                    System.out.println(String.format("id: %s; name: %s; description: %s;", el.getId(), el.getName(), el.getDesc()));
                }
            } else if (iRequest == 2) {
                String id = input.ask("Please enter the item's id:");
                String name = input.ask("Please enter the items's name:");
                String desc = input.ask("Please enter the item's description");
                long created = System.currentTimeMillis();
                Item item = new Item(id, name, desc, created);
                tracker.update(item);
            } else if (iRequest == 3) {
                String id = input.ask("Please enter the item's id:");
                String name = input.ask("Please enter the items's name:");
                String desc = input.ask("Please enter the item's description");
                long created = System.currentTimeMillis();
                Item item = new Item(id, name, desc, created);
                tracker.delete(item);
            } else if (iRequest == 4) {
                String id = input.ask("Please enter the item's id:");
                Item result = tracker.findById(id);
                System.out.println(String.format("id: %s; name: %s; description: %s;", result.getId(), result.getName(), result.getDesc()));
            } else if (iRequest == 5) {
                String name = input.ask("Please enter the item's name:");
                Item[] result = tracker.findByName(name);
                for (Item el : result) {
                    System.out.println(String.format("id: %s; name: %s; description: %s;", el.getId(), el.getName(), el.getDesc()));
                }
            }
        }
    }

    /**
     * Method main to run execution of the program.
     * @param args - java key words and operators.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}