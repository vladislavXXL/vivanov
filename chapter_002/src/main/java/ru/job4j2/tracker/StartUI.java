package ru.job4j2.tracker;

/**
 * Class StartUI.
 * @author vivanov
 * @version 1
 * @since 09.07.2017
 */
public class StartUI {

    /** field contstant key to ADD. */
    private static final int ADD  = 0;

    /** field constant key to SHOW. */
    private static final int SHOW = 1;

    /** field constant key to EDIT. */
    private static final int EDIT = 2;

    /** field constant key to DELETE. */
    private static final int DELETE = 3;

    /** field constant key to FIND by ID. */
    private static final int FINDID = 4;

    /** field constant key to FIND by NAME. */
    private static final int FINDNM = 5;

    /** field constant key to EXIT. */
    private static final int EXIT = 6;

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
     * Handler to process the addition of an item.
     * @param tracker - current tracker.
     */
    public void addHandler(Tracker tracker) {
        String id = input.ask("Please enter the item's id:");
        String name = input.ask("Please enter the items's name:");
        String desc = input.ask("Please enter the item's description");
        long created = System.currentTimeMillis();
        Item item = new Item(id, name, desc, created);
        tracker.add(item);
    }

    /**
     * Handler to show an items from the tracker.
     * @param tracker - current tracker.
     */
    public void showHandler(Tracker tracker) {
        Item[] result = tracker.findAll();
        for (Item el : result) {
            System.out.println(String.format("id: %s; name: %s; description: %s;", el.getId(), el.getName(), el.getDesc()));
        }
    }

    /**
     * Handler to edit an item in the tracker.
     * @param tracker - current tracker.
     */
    public void editHandler(Tracker tracker) {
        String id = input.ask("Please enter the item's id:");
        String name = input.ask("Please enter the items's name:");
        String desc = input.ask("Please enter the item's description");
        long created = System.currentTimeMillis();
        Item item = new Item(id, name, desc, created);
        tracker.update(item);
    }

    /**
     * Handler to delete an item from the tracker.
     * @param tracker - current tracker.
     */
    public void deleteHandler(Tracker tracker) {
        String id = input.ask("Please enter the item's id:");
        String name = input.ask("Please enter the items's name:");
        String desc = input.ask("Please enter the item's description");
        long created = System.currentTimeMillis();
        Item item = new Item(id, name, desc, created);
        tracker.delete(item);
    }

    /**
     * Handler to find the item by ID.
     * @param tracker - current tracker.
     */
    public void findByIdHandler(Tracker tracker) {
        String id = input.ask("Please enter the item's id:");
        Item result = tracker.findById(id);
        System.out.println(String.format("id: %s; name: %s; description: %s;", result.getId(), result.getName(), result.getDesc()));
    }

    /**
     * Handler to find the item by name.
     * @param tracker - current tracker.
     */
    public void findByNameHandler(Tracker tracker) {
        String name = input.ask("Please enter the item's name:");
        Item[] result = tracker.findByName(name);
        for (Item el : result) {
            System.out.println(String.format("id: %s; name: %s; description: %s;", el.getId(), el.getName(), el.getDesc()));
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
            if (iRequest == EXIT) {
                bQuit = true;
            } else if (iRequest == ADD) {
                addHandler(tracker);
            } else if (iRequest == SHOW) {
                showHandler(tracker);
            } else if (iRequest == EDIT) {
                editHandler(tracker);
            } else if (iRequest == DELETE) {
                deleteHandler(tracker);
            } else if (iRequest == FINDID) {
                findByIdHandler(tracker);
            } else if (iRequest == FINDNM) {
                findByNameHandler(tracker);
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