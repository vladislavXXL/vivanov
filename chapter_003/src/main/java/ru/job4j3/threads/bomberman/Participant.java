package ru.job4j3.threads.bomberman;

/**
 * Class Participant.
 *
 * @author v.ivanov
 * @version 1
 * @since 12.05.2019
 */
public abstract class Participant {

    /** Field name.*/
    private String name;

    /** Field current position.*/
    private Cell position;

    /**
     * Class Participant constructor.
     *
     * @param position start position Cell value
     * @param name participant name
     */
    public Participant(Cell position, String name) {
        this.position = position;
        this.name = name;
    }

    /**
     * Getter of field name.
     *
     * @return name value
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of field position.
     *
     * @return Cell value
     */
    public Cell getPosition() {
        return this.position;
    }

    /**
     * Setter of field position.
     *
     * @param position Cell value
     */
    public void setPosition(Cell position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Participant{" + "name='" + name + ", position=(" + position.getX() + ";" + position.getY() + ")}";
    }
}
