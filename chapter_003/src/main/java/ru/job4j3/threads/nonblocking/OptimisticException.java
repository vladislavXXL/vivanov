package ru.job4j3.threads.nonblocking;

/**
 * Class OptimisticException.
 *
 * @author v.ivanov
 * @version 1
 * @since 24.02.2019
 */
public class OptimisticException extends RuntimeException {

    /**
     * OptimisticException constructor.
     *
     * @param message to print when exception throws
     */
    public OptimisticException(String message) {
        super(message);
    }
}
