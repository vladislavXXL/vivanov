package ru.job4j3.threads.bomberman;

import org.junit.Test;
import java.util.concurrent.TimeUnit;

/**
 * Class GameTest.
 * @author v.ivanov
 * @version 1
 * @since 13.05.2019
 */
public class GameTest {

    /**
     * Method to run board with hero.
     */
    @Test
    public void createBoardAndRunHeroes() {
        Hero bMan = new Hero(new Cell(0, 0), "Bomberman");
        new Game(5, bMan).runGame();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
