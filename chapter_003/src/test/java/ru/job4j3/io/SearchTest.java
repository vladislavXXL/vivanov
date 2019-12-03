package ru.job4j3.io;

import com.google.common.collect.ImmutableMap;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;

/**
 * Class SearchTest.
 *
 * @author vivanov
 * @version 1
 * @since 07.09.2019
 */
public class SearchTest {
    /** Field Search class instance.*/
    private static Search search;

    /** Path to temporary directory. */
    private static final String PATH = System.getProperty("java.io.tmpdir");

    /** System file separator.*/
    private static final String SEP = System.getProperty("file.separator");

    /** Directory for file searching.*/
    private static final String MY = "TEST-DIRECTORY";

    /** Testing directory with subdirectories and files.*/
    private static final ImmutableMap<String, Character> MAP_OF_FILES = ImmutableMap.<String, Character>builder()
            .put(PATH + MY, 'd')
            .put(PATH + MY + SEP + "subdir1", 'd')
            .put(PATH + MY + SEP + "subdir2", 'd')
            .put(PATH + MY + SEP + "subdir3", 'd')
            .put(PATH + MY + SEP + "subdir1" + SEP + "subdir1-end", 'd')
            .put(PATH + MY + SEP + "subdir1" + SEP + "file1.txt", 'f')
            .put(PATH + MY + SEP + "subdir1" + SEP + "file2.log", 'f')
            .put(PATH + MY + SEP + "subdir1" + SEP + "subdir1-end" + SEP + "file3.txt", 'f')
            .put(PATH + MY + SEP + "subdir1" + SEP + "subdir1-end" + SEP + "file4.myext", 'f')
            .put(PATH + MY + SEP + "subdir2" + SEP + "file5.txt", 'f')
            .put(PATH + MY + SEP + "subdir2" + SEP + "file6.log", 'f')
            .put(PATH + MY + SEP + "subdir3" + SEP + "file7.txt", 'f')
            .put(PATH + MY + SEP + "subdir3" + SEP + "file8.log", 'f')
            .put(PATH + MY + SEP + "subdir3" + SEP + "file9.myext", 'f')
            .put(PATH + MY + SEP + "subdir3" + SEP + "file10.myext", 'f')
            .build();

    /**
     * Method to make preparations for tests.
     */
    @BeforeClass
    public static void setUp() {
        search = new Search();
        MAP_OF_FILES.keySet().forEach(e -> {
            File f = new File(e);
            if (MAP_OF_FILES.get(e).equals('d')) {
                f.mkdir();
            } else if (MAP_OF_FILES.get(e).equals('f')) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to check files extensions searching.
     */
    @Test
    public void checkSearchFilesByExtensions() {
        List<File> actualFiles = search.files(PATH + MY, Arrays.asList(".txt", ".log"));
        List<String> actualFilesNames = actualFiles.stream()
                .map(File::getName)
                .sorted()
                .collect(Collectors.toList());
        List<String> expectedFilesNames = Arrays.asList(
                "file1.txt",
                "file2.log",
                "file3.txt",
                "file5.txt",
                "file6.log",
                "file7.txt",
                "file8.log"
        );
        Assert.assertThat(actualFilesNames, is(expectedFilesNames));
    }

    /**
     * Method to run delete created files and directory after test completed.
     *
     * @throws IOException throws on exception
     */
    @AfterClass
    public static void deleteCreated() throws IOException {
        deleteDirectory(PATH + MY);
    }

    /**
     * Method to delete directory recursively.
     *
     * @param path path to directory
     * @throws IOException throws on exception
     */
    private static void deleteDirectory(String path) throws IOException {
        File file = new File(path);
        File[] toDelete = file.listFiles();
        if (toDelete != null) {
            for (File f : toDelete) {
                deleteDirectory(f.getAbsolutePath());
            }
        }
        if (!file.delete()) {
            throw new IOException("Can't delete file " + file.getName());
        }
    }
}