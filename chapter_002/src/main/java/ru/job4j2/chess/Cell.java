package ru.job4j2.chess;

import ru.job4j2.chess.exceptions.NegativeValueException;

/**
 * Class Cell describes cell on chess board.
 * @author vivanov
 * @version 1
 * @since 28.11.2017
 */
public class Cell {

    /** field x-coordinate.*/
    private int x;

    /** field y-coordinate.*/
    private int y;

    /**
     * Class Cell constructor.
     * @param x - coordinate
     * @param y - coordinate
     */
    public Cell(int x, int y) {
        if (x < 0) {
            throw new NegativeValueException("Please enter not negative value of X coordinate.");
        }
        if (y < 0) {
            throw new NegativeValueException("Please enter not negative value of Y coordinate");
        }
        if (x >= 0) {
            this.x = x;
        }
        if (y >= 0) {
            this.y = y;
        }
    }

    /**
     * x-coordinate getter.
     * @return x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * y-coordinate getter.
     * @return y-coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * x-coordinate setter.
     * @param x - x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * y-coordinate setter.
     * @param y - y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}
