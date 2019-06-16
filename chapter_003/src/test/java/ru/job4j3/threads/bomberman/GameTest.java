package ru.job4j3.threads.bomberman;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Monster> monsterList = Arrays.asList(
                new Monster(new Cell(1, 1), "Monster1"),
                new Monster(new Cell(2, 2), "Monster2"),
                new Monster(new Cell(3, 3), "Monster3")
        );
        new Game(5, bMan, monsterList, 3).runGame();
    }
}
