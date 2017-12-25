package ru.job4j2.chess.exceptions;

/**
 * Class ImpossibleMoveException.
 * @author vivanov
 * @version 1
 * @since 04.12.2017
 */
public class ImpossibleMoveException extends RuntimeException {

    /**
     * Constructor ImpossibleMoveException.
     * @param message to print when exception throws
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}