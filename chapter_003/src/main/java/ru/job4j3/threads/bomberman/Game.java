package ru.job4j3.threads.bomberman;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Game bomberman.
 *
 * @author v.ivanov
 * @version 1
 * @since 08.06.2019
 */
public class Game {

    /** Field board.*/
    private final Board board;

    /** Field bomberman.*/
    private final Hero bomberman;

    /**
     * Class Game constructor.
     *
     * @param size board size
     * @param bomberman Hero instance
     */
    public Game(int size, Hero bomberman) {
        this.board = new Board(size);
        this.bomberman = bomberman;
    }

    /**
     * Method to start game.
     */
    public void runGame() {
        ReentrantLock[][] locks = this.board.getBoard();
        Cell source = this.bomberman.getPosition();
        new Thread(() -> {
            while (true) {
                try {
                    boolean isBusy = locks[source.getX()][source.getY()].tryLock(500, TimeUnit.MILLISECONDS);
                    if (isBusy) {
                        boolean isMoved;
                        do {
                            isMoved = this.board.move(source, generateDest());
                        } while (!isMoved);
                    }
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Method to random generate Cell coordinates values.
     *
     * @return new cell result
     */
    private Cell generateDest() {
        Cell result;
        int size = this.board.getSize();
        while (true) {
            int x = new Random().nextInt(size);
            int y = new Random().nextInt(size);
            if (x >= 0 && y >= 0 && x < size && y < size) {
                result = new Cell(x, y);
                break;
            }
        }
        return result;
    }
}
