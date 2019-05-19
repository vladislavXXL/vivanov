package ru.job4j3.threads.bomberman;

/**
 * Class Cell.
 *
 * @author v.ivanov
 * @version 1
 * @since 12.05.2019
 */
public class Cell {

    /** Field position x.*/
    private int x;

    /** Field position y.*/
    private int y;

    /**
     * Class Cell constructor.
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter x coordinate.
     *
     * @return x value
     */
    public int getX() {
        return x;
    }

    /**
     * Getter y coordinate.
     *
     * @return y value
     */
    public int getY() {
        return y;
    }

     /**
     * Method toString.
     * @return result description of Cell instance
     */
    @Override
    public String toString() {
        return "Cell{" + "x=" + this.x + ", y=" + this.y + '}';
    }
}
