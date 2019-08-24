package ru.job4j3.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Analyze.
 *
 * @author vivanov
 * @version 1
 * @since 16.08.2019
 */
public class Analyze {
    /**
     * Method to define unavailable time.
     *
     * @param source not analyzed file
     * @param target analyzed file
     */
    public void unavailable(String source, String target) {
        String path = System.getProperty("user.dir").replace("chapter_003", "");
        try (BufferedReader reader = new BufferedReader(new FileReader(path + source))) {
            Iterator<String> itr = reader.lines().iterator();
            boolean isOut = false;
            StringBuilder newLine = new StringBuilder();
            while (itr.hasNext()) {
                String itrVal = itr.next();
                if (!itrVal.isEmpty()) {
                    if (!isOut && (itrVal.startsWith("400") || itrVal.startsWith("500"))) {
                        newLine.append(itrVal.split(" ")[1]).append("; ");
                        isOut = true;
                    }
                    if (isOut && (itrVal.startsWith("200") || itrVal.startsWith("300"))) {
                        writeToFile(target, newLine.append(itrVal.split(" ")[1]).append("\n").toString());
                        isOut = false;
                        newLine.setLength(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to write into file.
     * @param fileName file name
     * @param value value to write
     */
    private void writeToFile(String fileName, String value) {
        String path = System.getProperty("user.dir").replace("chapter_003", "");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(path + fileName, true))) {
            out.print(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get lines from file into List.
     *
     * @param fileName name of file
     * @return list result
     */
    public List<String> readFromFileToList(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(System.getProperty("user.dir").replace("chapter_003", "") + fileName))
        ) {
            result = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
