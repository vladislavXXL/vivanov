package ru.job4j3.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class Zip to archive project.
 *
 * @author v.ivanov
 * @version 1
 * @since 13.01.2020
 */
public class Zip {

    /** Field extension value to exclude from archive.*/
    private String toExclude;

    /**
     * Zip class constructor.
     *
     * @param toExclude extension value
     */
    public Zip(String toExclude) {
        this.toExclude = toExclude;
    }

    /**
     * Mehthod to made archive.
     *
     * @param source directory
     * @param target archive
     * @throws IOException throws on error
     */
    private void pack(File source, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            seekBy(source.getPath(), this.toExclude).forEach(f -> {
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(f))) {
                    zip.putNextEntry(new ZipEntry(f.getPath()));
                    byte[] buffer = new byte[out.available()];
                    zip.write(buffer);
                    zip.closeEntry();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * Method to find list of files which will included into archive.
     *
     * @param root parent directory
     * @param ext extension value not included into archive
     * @return result list of files to archive
     * @throws IOException throws exception on error
     */
    private List<File> seekBy(String root, String ext) throws IOException {
        return Files.find(
                Paths.get(new File(root).getPath()),
                Integer.MAX_VALUE,
                (path, attr) -> !path.toFile().getName().matches("(." + ext + ")"))
                .map(e -> new File(String.valueOf(e)))
                .collect(Collectors.toList());
    }

    /**
     * Entry point.
     *
     * @param args to define archive parameters
     * @throws IOException throws exception on error
     */
    public static void main(String[] args) throws IOException {
        Args arg = new Args(args);
        new Zip(arg.exclude()).pack(new File(arg.directory()), new File(arg.output()));
    }
}
