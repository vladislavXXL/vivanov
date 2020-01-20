package ru.job4j3.io;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * ArgsTest class to test Args class.
 *
 * @author  v.ivanov
 * @version 1
 * @since   20.01.2020
 */
public class ArgsTest {

    /**
     * Method to check directory().
     */
    @Test
    public void checkDirectory() {
        Args args = new Args(new String[] {"-d", "c:\\project\\job4j\\", "-e", "*.java", "-o", "project.zip"});
        Assert.assertThat(args.directory(), is("c:\\project\\job4j\\"));
    }

    /**
     * Method to check exclude().
     */
    @Test
    public void checkExclude() {
        Args args = new Args(new String[] {"-d", "c:\\project\\job4j\\", "-e", "*.java", "-o", "project.zip"});
        Assert.assertThat(args.exclude(), is("*.java"));
    }

    /**
     * Method to check output().
     */
    @Test
    public void checkOutput() {
        Args args = new Args(new String[] {"-d", "c:\\project\\job4j\\", "-e", "*.java", "-o", "project.zip"});
        Assert.assertThat(args.output(), is("project.zip"));
    }

    /**
     * Method to check exception if parameter key is wrong.
     */
    @Test(expected = RuntimeException.class)
    public void checkWrongParameterName() {
        Args args = new Args(new String[] {"-d", "c:\\project\\job4j\\", "-eerw", "*.java", "-o", "project.zip"});
        args.exclude();
    }

    /**
     * Method to chek exception if parameter key is absent.
     */
    @Test(expected = RuntimeException.class)
    public void checkAbsentParameterOutput() {
        Args args = new Args(new String[] {"-d", "c:\\project\\job4j\\", "-e", "*.java", "project.zip"});
        args.output();
    }
}
