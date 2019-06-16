package ru.job4j3.threads.bomberman;

import java.util.List;
import java.util.stream.IntStream;

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

    /** Field monsters.*/
    private final List<Monster> monsters;

    /** Field blocked cells.*/
    private final int block;

    /** Field flag of thread running.*/
    private boolean isRun = true;

    /**
     * Class Game constructor.
     *
     * @param size board size
     * @param bomberman Hero instance
     * @param monsters Monster's list
     * @param block blocked static cells
     */
    public Game(int size, Hero bomberman, List<Monster> monsters, int block) {
        this.board = new Board(size);
        this.bomberman = bomberman;
        this.monsters = monsters;
        this.block = block;
        // Setting static blocked cells
        IntStream.range(0, block).forEach(e -> this.board.setLock(this.board.generateDest()));
    }

    /**
     * Method to start game.
     */
    public void runGame() {
        // Monsters thread
        Thread mThread = new Thread(() ->
                this.monsters.forEach(m -> {
                    this.board.setLock(m.getPosition());
                    try {
                        while (isRun) {
                            this.board.runActions(m);
                            System.out.println(m.getName() + " moved to: " + m.getPosition());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
        );
        mThread.setDaemon(true);
        Cell source = this.bomberman.getPosition();
        // Bomberman thread
        Thread bThread = new Thread(() -> {
            try {
                int bomberSteps = 100;
                this.board.setLock(source);
                while (isRun) {
                    this.board.runActions(this.bomberman);
                    if (this.board.getBoard()[this.bomberman.getPosition().getX()][this.bomberman.getPosition().getY()].hasQueuedThread(mThread)) {
                        isRun = false;
                        System.out.println("GAME OVER!");
                    }
                    bomberSteps--;
                    if (bomberSteps == 0) {
                        isRun = false;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        bThread.start();
        mThread.start();
        try {
            bThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to print out locked and free cells.
     */
    public void getLocked() {
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                System.out.format("%d: %d; Is locked: %b\n", i, j, this.board.getBoard()[i][j].isLocked());
            }
        }
    }
}
