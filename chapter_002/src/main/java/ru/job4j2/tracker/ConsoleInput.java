package ru.job4j2.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 * @author vivanov
 * @version 1
 * @since 09.07.2017
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}