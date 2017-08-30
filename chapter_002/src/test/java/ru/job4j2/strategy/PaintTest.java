package ru.job4j2.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class PaintTest.
 * @author vivanov
 * @version 1
 * @since 30.08.2017
 */

public class PaintTest {

    /**
     * Test Triangle shape.
     */
    @Test
    public void whenShapeIsTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint result = new Paint();
        result.draw(new Triangle());
        assertThat(out.toString(), is("   +\n  +++\n +++++\n+++++++\n"));
    }

    /**
     * Test Square shape.
     */

    @Test
    public void whenShapeIsSquare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint result = new Paint();
        result.draw(new Square());
        assertThat(out.toString(), is("++++\n++++\n++++\n++++\n"));
    }

}
