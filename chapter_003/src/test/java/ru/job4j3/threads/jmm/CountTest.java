package ru.job4j3.threads.jmm;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test Count.
 * @author v.ivanov
 * @version 1
 * @since 23.12.2018
 */
public class CountTest {

    /**
     * Class ThreadCount allow to use class Count with multithreading.
     * @author v.ivanov
     * @version 1
     * @since 23.12.2018
     */
    private class ThreadCount extends Thread {

        /** Field count.*/
        private final Count count;

        /**
         * Class ThreadCount constructro.
         * @param count field for increasing
         */
        private ThreadCount(final Count count) {
            this.count = count;
        }

        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         */
        @Override
        public void run() {
            this.count.increment();
        }
    }

    /**
     * Method to run two threads.
     * @throws InterruptedException exception
     */
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {

        final Count count = new Count();
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);

        first.start();
        second.start();
        first.join();
        second.join();

        System.out.println(count.get());
        assertThat(count.get(), is(2));
    }
}