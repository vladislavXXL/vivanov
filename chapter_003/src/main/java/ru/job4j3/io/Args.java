package ru.job4j3.io;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Class Args.
 *
 * @author v.ivanov
 * @version 1
 * @since 17.01.2020
 */
public class Args {

    /** Field map with arguments keys and values.*/
    private Map<String, String> argsMap;

    /**
     * Class Args constructor.
     *
     * @param args array value
     */
    public Args(String[] args) {
        this.argsMap = new HashMap<>();
        Stream.of("-d", "-e", "-o").forEach(e -> {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals(e) && !args[i + 1].startsWith("-")) {
                    this.argsMap.put(e, args[i + 1]);
                    break;
                }
            }
        });
    }

    /**
     * Method used to get arg value.
     *
     * @param param value of parameter to be found
     * @return result value
     */
    private String getArgValue(String param) {
        String result = this.argsMap.get(param);
        if (!result.isEmpty()) {
            return result;
        } else {
            throw new RuntimeException("Command syntax error occurred");
        }
    }

    /**
     * Method to return directory to be archived.
     *
     * @return directory value
     */
    public String directory() {
        return getArgValue("-d");
    }

    /**
     * Method to return file extension to exclude.
     *
     * @return extension value
     */
    public String exclude() {
        return getArgValue("-e");
    }

    /**
     * Method to return output directory.
     *
     * @return output directory value
     */
    public String output() {
        return getArgValue("-o");
    }
}
