package ru.job4j2.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class ChessTest.
 * @author vivanov
 * @version 1
 * @since 17.12.2017
 */
public class ChessTest {

    /**
     *  Method BishopLogicTest to test Bishop class Behavior.
     */
    @Test
    public void whenUsedBishopFigureLogic() {
        Board board = new Board();
        Cell cellBishop = new Cell(2, 0);
        Bishop bishop = new Bishop(cellBishop);
        board.setFigure(cellBishop, bishop);
        Cell destCell = new Cell(6, 4);
        board.move(cellBishop, destCell);
        Figure result = board.getFigure(destCell);
        assertThat(result.getPosition().getX(), is(destCell.getX()));
        assertThat(result.getPosition().getY(), is(destCell.getY()));
    }
}