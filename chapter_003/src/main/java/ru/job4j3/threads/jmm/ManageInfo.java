package ru.job4j3.threads.jmm;

/**
 * Class ManageInfo manipulates with class Info via multithreading.
 * @author v.ivanov
 * @version 1
 * @since 16.12.2018
 */
public class ManageInfo implements Runnable {

    /** Field info.*/
    private Info info;

    /**
     * Class ManageInfo constructor.
     * @param info instance initialization
     */
    public ManageInfo(Info info) {
        this.info = info;
    }

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
        int key = this.info.getKey();
        this.info.setKey(key + 10);
    }
}
