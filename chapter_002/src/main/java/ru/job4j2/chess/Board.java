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
     * @return figure object
     * @param position - Cell of the figure position
     * @return
     */
    public Figure getFigure(Cell position) {
        return figures[position.getX()][position.getY()];
    }

    /**
     * Field figures setter.
     * @param position - Cell of the figure position.
     * @param figure - result figrue
     */
    public void setFigure(Cell position, Bishop figure) {
        this.figures[position.getX()][position.getY()] = figure;
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

        Figure figureCheck = this.getFigure(source);

        if (figureCheck != null) {

            Cell[] wayCellsArr = figures[source.getX()][source.getY()].way(dest);
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