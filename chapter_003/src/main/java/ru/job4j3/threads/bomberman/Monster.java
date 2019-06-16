package ru.job4j3.threads.bomberman;

/**
 * Class Monster.
 *
 * @author v.ivanov
 * @version 1
 * @since 16.06.2019
 */
public class Monster extends Participant {

    /**
     * Class Monster constructor.
     *
     * @param position start position
     * @param name Monster name
     */
    public Monster(Cell position, String name) {
        super(position, name);
    }
}
