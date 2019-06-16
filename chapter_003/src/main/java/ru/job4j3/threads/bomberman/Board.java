package ru.job4j3.threads.bomberman;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Board.
 *
 * @author v.ivanov
 * @version 1
 * @since 12.05.2019
 */
public class Board {

    /** Field board.*/
    private final ReentrantLock[][] board;

    /** Field board dimensions.*/
    private final int size;

    /**
     * Class Board constructor.
     *
     * @param size board dimension value
     */
    public Board(final int size) {
        this.size = size;
        this.board = new ReentrantLock[size][size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * Field board getter.
     *
     * @return ReentrantLock[][] instance
     */
    public ReentrantLock[][] getBoard() {
        return this.board;
    }

    /**
     * Field size getter.
     * @return int board size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Method to move hero.
     *
     * @param source start position
     * @param dest destination position
     * @return result of operation
     * @throws InterruptedException exception
     */
    private boolean move(Cell source, Cell dest) throws InterruptedException {
        System.out.println("Source cell is locked: " + this.board[source.getX()][source.getY()].isLocked());
        boolean isDest = this.board[dest.getX()][dest.getY()].tryLock(500, TimeUnit.MILLISECONDS);
        System.out.println("Destination cell is locked: " + this.board[dest.getX()][dest.getY()].isLocked());
        if (isDest) {
            this.board[source.getX()][source.getY()].unlock();
            System.out.println("Source cell after, is locked: " + this.board[source.getX()][source.getY()].isLocked());
            System.out.println("Moved to " + dest);
        }
        return isDest;
    }

    /**
     * Method to lock participant position.
     *
     * @param cell position
     * @return result of operation
     */
    public boolean setLock(Cell cell) {
        boolean result = false;
        try {
            result = this.board[cell.getX()][cell.getY()].tryLock(5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method to run moving loop.
     *
     * @param participant Participant instance
     * @throws InterruptedException throws exception
     */
    public void runActions(Participant participant) throws InterruptedException {
        boolean isMoved;
        do {
            Cell dest = generateDest();
            isMoved = this.move(participant.getPosition(), dest);
            if (isMoved) {
                participant.setPosition(dest);
            }
        } while (!isMoved);
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    /**
     * Method to random generate Cell coordinates values.
     *
     * @return new cell result
     */
    public Cell generateDest() {
        Cell result;
        while (true) {
            int x = new Random().nextInt(this.size);
            int y = new Random().nextInt(this.size);
            if (x >= 0 && y >= 0 && x < this.size && y < this.size) {
                result = new Cell(x, y);
                break;
            }
        }
        return result;
    }
}
