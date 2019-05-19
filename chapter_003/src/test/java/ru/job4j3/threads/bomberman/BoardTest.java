package ru.job4j3.threads.bomberman;

import org.junit.Test;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Class BoardTest.
 * @author v.ivanov
 * @version 1
 * @since 13.05.2019
 */
public class BoardTest {

    /**
     * Method to run board with hero.
     */
    @Test
    public void createBoardAndRunHero() {
        Board board = new Board(5);
        board.setBoard();
        Participant yellowBall = new Hero(new Cell(0, 0), "Yellow Ball");
        board.addParticipant(Arrays.asList(yellowBall));
        board.startParticipant(yellowBall);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        board.stopParticipant();
    }
}
