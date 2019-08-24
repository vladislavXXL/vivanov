package ru.job4j3.io;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class AnalyzeTest.
 *
 * @author vivanov
 * @version 1
 * @since 22.08.2019
 */
public class AnalyzeTest {

    /** Class Analyze instance field.*/
    private static Analyze analyze;

    /** Source file name field.*/
    private static final String SOURCE_FILE = "log.txt";

    /** Target file name field.*/
    private static final String TARGET_FILE = "unavailable.csv";

    /** Expected String list field.*/
    private static final List<String> EXPECTED_LIST = Arrays.asList(
            "10:57:01; 10:59:01",
            "11:01:02; 11:02:02",
            "11:07:55; 11:11:11",
            "11:12:41; 11:15:33",
            "11:18:19; 11:21:54",
            "11:45:32; 11:51:47",
            "12:01:43; 12:35:38",
            "13:57:43; 14:28:19"
    );

    /**
     * Initialization method.
     */
    @BeforeClass
    public static void setUp() {
        analyze = new Analyze();
        analyze.unavailable(SOURCE_FILE, TARGET_FILE);
    }

    /**
     * Method to check creating target file and writing values inside it.
     */
    @Test
    public void checkGetUnavailable() {
        assertThat(analyze.readFromFileToList(TARGET_FILE), is(EXPECTED_LIST));
    }

    /**
     * Method to delete file after tests finished.
     */
    @AfterClass
    public static void delete() {
        String path = System.getProperty("user.dir").replace("chapter_003", "");
        File file = new File(path + TARGET_FILE);
        boolean isDelete = file.delete();
        Assert.assertTrue("FAIL -> file doesn't deleted", isDelete);
    }
}
