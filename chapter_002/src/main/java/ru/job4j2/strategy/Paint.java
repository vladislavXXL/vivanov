package ru.job4j2.strategy;

/**
 * Class Paint to draw the shape.
 * @author vivanov
 * @version 1
 * @since 30.08.2017
 */

public class Paint {
    /**
     * Method draw - to draw the shape.
     * @param shape - selected type of shape
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
}
