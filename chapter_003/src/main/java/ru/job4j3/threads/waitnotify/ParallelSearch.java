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
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(10);
        final Thread consumer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println(queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        consumer.start();
        new Thread(() -> {
            for (int index = 0; index != queue.getCapacity(); index++) {
                queue.offer(index);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            consumer.interrupt();
        }).start();
    }
}
