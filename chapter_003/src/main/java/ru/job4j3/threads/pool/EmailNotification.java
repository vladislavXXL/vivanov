package ru.job4j3.threads.pool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class EmailNotification used to send email.
 *
 * @author v.ivanov
 * @version 1
 * @since 10.03.2019
 */
public class EmailNotification {

    /** Field pool.*/
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * Getter for field pool.
     *
     * @return pool instance
     */
    public ExecutorService getPool() {
        return pool;
    }

    /**
     * Method to send email.
     *
     * @param user email recipient.
     */
    public void emailTo(User user) {
        String subject = String.format("Notification %s to email %s", user.getUsername(), user.getEmail());
        String body = String.format("Add a new event to %s", user.getUsername());
        this.pool.submit(() ->
                send(subject, body, user.getEmail())
        );
    }

    /**
     * Method to send email.
     * @param subject subject of email
     * @param body body of email
     * @param email email value
     */
    public void send(String subject, String body, String email) {

    }

    /**
     * Method to close all threads.
     */
    public void close() {
        this.pool.shutdown();
    }
}
