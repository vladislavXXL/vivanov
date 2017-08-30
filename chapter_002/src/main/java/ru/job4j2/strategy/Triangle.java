package ru.job4j2.strategy;

/**
 * Class Triangle.
 * @author vivanov
 * @version 1
 * @since 30.08.2017
 */

public class Triangle implements Shape {

    /**
     * Method pic - is used to build a shape picture.
     * @return result picture.
     */
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +\n  +++\n +++++\n+++++++\n");
        return pic.toString();
    }
}
