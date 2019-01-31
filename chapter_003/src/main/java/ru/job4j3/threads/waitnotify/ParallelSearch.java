package ru.job4j3.threads.waitnotify;

/**
 * Class ParallelSearch.
 * @uathor v.ivanov
 * @version 1
 * @since 29.01.2019
 */
public class ParallelSearch {
    static boolean flag = false;
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>(3);
        final Thread consumer = new Thread(() -> {
            while (!flag) {
                try {
                    System.out.println(queue.poll());
                    if (queue.getSize() == 0) {
                        throw new InterruptedException();
                    }
                } catch (Exception e) {
                    System.out.println("Interrupted");
                    //e.printStackTrace();
                    //if (queue.getSize() == 0 && Thread.currentThread().isInterrupted()) {
                        flag = true;
                        //Thread.currentThread().interrupt();
                    //}
                }
            }
        });
        consumer.start();
        Thread producer = new Thread(() -> {
            for (int index = 0; index != 3; index++) {
                queue.offer(index);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
            }


/*
            if (Thread.interrupted()) {
                System.out.println("Consumer interrupted");
                Thread.currentThread().interrupt();
            }
*/


        });
        producer.start();
    }

}
