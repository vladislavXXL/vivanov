package ru.job4j3.io;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.File;

/**
 * Class ChatTest to test class Chat.
 *
 * @author v.ivanov
 * @version 1
 * @since 10.02.2020
 */
public class ChatTest {

    /** Field Chat instance.*/
    private static Chat obj;

    /**
     * Initialization method.
     */
    @BeforeClass
    public static void setUp() {
        BufferedReader inStream = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(
                        "Привет, это набор слов\nдля проверки диалога\nстоп\nбез ответов\nпродолжить\nеще ответ\nзакончить".getBytes()
                )
        ));
        obj = new Chat(inStream, "стоп", "продолжить", "закончить");
    }

    /**
     * Check Chat class.
     *
     * @throws IOException on logging
     */
    @Test
    public void checkClassTest() throws IOException {
        obj.startChat();
    }

    /**
     * Method to remove created log file in this test.
     *
     * @throws IOException throws IOException on delete
     */
    @AfterClass
    public static void removeCreatedLogFile() throws IOException {
        File toDelete = obj.getLogger().getLogFile();
        if (!toDelete.delete()) {
            throw new IOException("Can't delete " + toDelete.getName());
        }
    }
}