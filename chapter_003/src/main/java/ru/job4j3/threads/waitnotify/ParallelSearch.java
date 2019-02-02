package ru.job4j3.threads.waitnotify;

/**
 * Class ParallelSearch.
 * @author v.ivanov
 * @version 1
 * @since 29.01.2019
 */
public class ParallelSearch {
    /**
     * Main method.
     * @param args params
     */
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(3);
        final Thread consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(queue.poll());
            }
        });
        consumer.start();
        new Thread(() -> {
            for (int index = 0; index != 3; index++) {
                queue.offer(index);
                if (index == 2) {
                    consumer.interrupt();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
