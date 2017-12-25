package ru.job4j2.chess.exceptions;

/**
 * Class FigureNotFoundException.
 * @author vivanov.
 * @version 1
 * @since 10.12.2017
 */
public class FigureNotFoundException extends RuntimeException {

    /**
     * Constructor FigureNotFoundException.
     * @param msg - message to print when exception throws
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}