package ru.job4j3.threads.pool;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Class ThreadDeadlockFinder used to identify deadlock.
 * @author v.ivanov
 * @version 1
 * @since 07.04.2019
 */
public class ThreadDeadlockFinder implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
            long[] ids = tmx.findDeadlockedThreads();
            if (ids != null) {
                ThreadInfo[] info = tmx.getThreadInfo(ids, true, true);
                System.out.format("This threads are making deadlock:\n\n");
                for (ThreadInfo ti : info) {
                    System.out.println(ti);
                }
                throw new RuntimeException("Deadlock detected.");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
