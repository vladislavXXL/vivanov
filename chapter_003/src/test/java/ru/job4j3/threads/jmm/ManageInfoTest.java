package ru.job4j3.threads.jmm;

import org.junit.Test;

/**
 * Class ManageInfoTest for testing class ManageInfo.
 * @author v.ivanov
 * @version 1
 * @since 16.12.2018
 */
public class ManageInfoTest {

    /**
     * Run threads.
     */
    @Test
    public void runSeveralThreads() {
        Info info = new Info(1);
        Thread thread1 = new Thread(new ManageInfo(info));
        Thread thread2 = new Thread(new ManageInfo(info));
        Thread thread3 = new Thread(new ManageInfo(info));
        Thread thread4 = new Thread(new ManageInfo(info));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(info.getKey());
    }
}