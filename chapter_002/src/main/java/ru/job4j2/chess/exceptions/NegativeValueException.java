package ru.job4j2.chess.exceptions;

/**
 * Class NegativeValueException.
 * @author vivanov
 * @version 1
 * @since 10.12.2017
 */
public class NegativeValueException extends RuntimeException {
    /**
     * Constructor NegativeValueException.
     * @param message to print when exception throws
     */
    public NegativeValueException(String message) {
        super(message);
    }
}
