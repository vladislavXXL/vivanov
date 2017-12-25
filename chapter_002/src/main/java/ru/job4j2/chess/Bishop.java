package ru.job4j2.chess;

import ru.job4j2.chess.exceptions.ImpossibleMoveException;

/**
 * Class Bishop.
 * @author vivanov
 * @version 1
 * @since 04.12.2017
 */
public class Bishop extends Figure {

    /**
     * Bishop class constructor.
     * @param dest position on the chess board.
     */
    public Bishop(Cell dest) {
        super(dest);
    }

    /**
     * Method to get cells which belongs to the distance figure moves.
     * @param source - start position of the figure
     * @param dest - final position of the figure
     * @return array of all valid cells on distance between start and finial
     * @throws ImpossibleMoveException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {

        int deltaX = Math.abs(source.getX() - dest.getX());
        int deltaY = Math.abs(source.getY() - dest.getY());
        if (deltaX == deltaY) {

            Cell[] result = new Cell[deltaX];

            if (source.getX() > dest.getX() && source.getY() > dest.getY()) {
                int inc = 0;
                for (int i = 1; i <= deltaX; i++) {
                    result[inc++] = new Cell(source.getX() - i, source.getY() - i);
                }
            }

            if (source.getX() > dest.getX() && source.getY() < dest.getY()) {
                int inc = 0;
                for (int i = 1; i <= deltaX; i++) {
                    result[inc++] = new Cell(source.getX() - i, source.getY() + i);
                }
            }

            if (source.getX() < dest.getX() && source.getY() < dest.getY()) {
                int inc = 0;
                for (int i = 1; i <= deltaX; i++) {
                    result[inc++] = new Cell(source.getX() + i, source.getY() + i);
                }
            }

            if (source.getX() < dest.getX() && source.getY() > dest.getY()) {
                int inc = 0;
                for (int i = 1; i <= deltaX; i++) {
                    result[inc++] = new Cell(source.getX() + i, source.getY() - i);
                }
            }

            return result;

        } else {
            throw new ImpossibleMoveException("Move figures to this position is impossible.");
        }
    }

    /**
     * Method to make new figure with defined position in dest parameter.
     * @param dest - position of the figure
     * @return result figure
     */
    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}