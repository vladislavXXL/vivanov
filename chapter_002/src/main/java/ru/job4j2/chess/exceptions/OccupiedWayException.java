package ru.job4j2.chess.exceptions;

/**
 * Class OccupiedWayException.
 * @author vivanov
 * @version 1
 * @since 10.12.2017
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * Constructor of the class OccupiedWayException.
     * @param message - to print when exception throws
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}