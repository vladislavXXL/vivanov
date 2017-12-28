package ru.job4j2.chess;

import ru.job4j2.chess.exceptions.ImpossibleMoveException;

/**
 * Figure - abstract class.
 * @author vivanov
 * @version 1
 * @since 28.11.2017
 */
public abstract class Figure {

    /** field position of figure. */
    private final Cell position;

    /**
     * Field position getter.
     * @return figure position
     */
    public Cell getPosition() {
        return this.position;
    }

    /**
     * Constructor of class Figure.
     * @param position - to define start position of figure
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Method to get cells which belongs to the distance figure moves.
     * @param dest - final position of the figure
     * @return array of all valid cells on distance between start and finial
     * @throws ImpossibleMoveException throws when some kind of movement is impossible.
     */
    abstract Cell[] way(Cell dest) throws ImpossibleMoveException;

    /**
     * Method to make new figure with defined position in dest parameter.
     * @param dest - position of the figure
     * @return result figure
     */
    abstract Figure copy(Cell dest);

}