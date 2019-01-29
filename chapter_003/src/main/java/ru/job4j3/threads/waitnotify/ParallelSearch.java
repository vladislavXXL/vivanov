package ru.job4j3.threads.waitnotify;

/**
 * Class ParallelSearch.
 * @uathor v.ivanov
 * @version 1
 * @since 29.01.2019
 */
public class ParallelSearch {
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(3);
        final Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(queue.poll());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        consumer.start();
        new Thread(() -> {
            for (int index = 0; index != 3; index++) {
                queue.offer(index);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
