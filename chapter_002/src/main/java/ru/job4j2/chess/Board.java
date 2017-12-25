package ru.job4j2.chess;

import ru.job4j2.chess.exceptions.FigureNotFoundException;
import ru.job4j2.chess.exceptions.ImpossibleMoveException;
import ru.job4j2.chess.exceptions.OccupiedWayException;

/**
 * Class Board is used to contain all the figures on the board.
 * @author vivanov
 * @version 1
 * @since 10.12.2017
 */
public class Board {

    /** figures is the array that used to implement the available figures on a chess board grid. */
    private Figure[][] figures = new Figure[8][8];

    /**
     * Field figures getter.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return figure object
     */
    public Figure getFigures(int x, int y) {
        return figures[x][y];
    }

    /**
     * Field figures setter.
     * @param x - x-coordinate
     * @param y - y-coordinate
     * @param figure - object of class Figure to set at Cell with the x and the y coordinates
     */
    public void setFigures(int x, int y, Bishop figure) {
        this.figures[x][y] = figure;
    }

    /**
     * Method move is used to move figure to another cell and checks if it possible.
     * @param source - source Cell
     * @param dest - destination Cell
     * @return result - true or false
     * @throws ImpossibleMoveException when move of the figure is impossible
     * @throws OccupiedWayException when cell is occupied already
     * @throws FigureNotFoundException when figure is not available on the board
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean result;
        boolean isFigureAvailable = false;

        for (int i = 0; i < figures.length; i++) {
            for (int j = 0; j < figures.length; j++) {
                if (figures[i][j] != null && figures[i][j].getPosition().getX() == source.getX() && figures[i][j].getPosition().getY() == source.getY()) {
                    isFigureAvailable = true;
                }
            }
        }

        if (isFigureAvailable) {

            Cell[] wayCellsArr = figures[source.getX()][source.getY()].way(source, dest);
            for (Cell el: wayCellsArr) {
                if (figures[el.getX()][el.getY()] != null) {
                    throw new OccupiedWayException("The cell (" + el.getX() + ", " + el.getY() + ")" +  " is occupied already.");
                }
            }

            this.figures[dest.getX()][dest.getY()] = figures[source.getX()][source.getY()].copy(dest);

            result = true;

        } else {
            throw new FigureNotFoundException("This figure is not found on this cell: (" + source.getX() + "; " + source.getY() + ")");
        }

        return result;
    }
}