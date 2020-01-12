package ru.job4j3.io;

import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Class Search.
 *
 * @author vivanov
 * @version 1
 * @since 07.09.2019
 */
public class Search {

    /**
     * Method files.
     *
     * @param parent directory
     * @param exts extensions to find
     * @return result list of files
     */
    List<File> files(String parent, List<String> exts) {
        List<File> files = new ArrayList<>();
        Queue<File> dirs = new LinkedList<>();
        File file = new File(parent);
        if (file.isDirectory()) {
            dirs.add(file);
            while (!dirs.isEmpty()) {
                 File file1 = dirs.poll();
                 if (file1.isDirectory() && Objects.requireNonNull(file.listFiles()).length != 0) {
                     dirs.addAll(Arrays.asList(file1.listFiles()));
                 } else {
                     exts.forEach(e -> {
                         if (file1.getName().contains(e)) {
                             files.add(file1);
                         }
                     });
                 }
            }
        }
        return files;
    }
}
