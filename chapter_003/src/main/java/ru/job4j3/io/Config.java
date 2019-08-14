package ru.job4j3.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Class Config.
 *
 * @author vivanov
 * @version 1
 * @since 13.08.2019
 */
public class Config {
    /** Field path.*/
    private final String path;

    /** Field values.*/
    private final Map<String, String> values = new HashMap<>();

    /**
     * Constructor Config.
     * @param path - path value
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * Method to load file content.
     * @throws IOException exception
     */
    public void load() throws IOException {
        String dir = System.getProperty("user.dir");
        String filePath = dir.replace("chapter_003", "") + this.path;
        try (BufferedReader read = new BufferedReader(new FileReader(filePath))) {
            read.lines().forEach(e -> {
                if (e.contains("=")) {
                    String[] line = e.split("=");
                    this.values.put(line[0], line[1]);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get value by key.
     * @param key value
     * @return String result
     */
    public String value(String key) {
        return this.values.get(key);
    }

    /**
     * Getter method to values field.
     * @return Map of values
     */
    public Map<String, String> getValues() {
        return this.values;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
