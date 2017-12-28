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
     * @param dest - final position of the figure
     * @return array of all valid cells on distance between start and finial
     * @throws ImpossibleMoveException
     */
    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException {
        Cell source = this.getPosition();
        int deltaX = source.getX() - dest.getX();
        int deltaY = source.getY() - dest.getY();

        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            Cell[] result = new Cell[Math.abs(deltaX)];

            for (int i = 0; i < Math.abs(deltaX); i++) {
                result[i] = new Cell(source.getX() + (deltaX < 0 ? 1 : -1) * (i + 1), source.getY() + (deltaY < 0 ? 1 : -1) * (i + 1));
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