package ru.job4j3.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Class ChatLogger.
 *
 * @author v.ivanov
 * @version 1
 * @since 10.02.2020
 */
public class ChatLogger {

    /** Field file name.*/
    private File logFile;

    /**
     * ChatLogger class constructor.
     *
     * @param fileName file to save log
     */
    public ChatLogger(String fileName) {
        String sep = System.getProperty("file.separator");
        this.logFile = new File(System.getProperty("user.dir").replace("chapter_003", "") + sep + "resources" + sep + fileName);
    }

    /**
     * Getter for field fileName.
     *
     * @return file name value
     */
    public File getLogFile() {
        return this.logFile;
    }

    /**
     * Method to write log info into file.
     *
     * @param value value to input
     */
    public void log(String value) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(logFile.getPath(), true))) {
            out.println(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
