package ru.job4j2.tracker;

/**
 * Class StartUI.
 * @autho vivanov
 * @version 1
 * @since 09.07.2017
 */
public class StartUI {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        String name = input.ask("Please enter the task's name: ");
        Tracker tracker = new Tracker();
        tracker.add(new Item("1", name, "First description", 123L));
        for (Item el : tracker.getAll()) {
            if (el != null) System.out.println(el.getName());
        }

    }
}