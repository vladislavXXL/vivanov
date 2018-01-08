package ru.job4j2.coffeemachine.changeexceptions;

/**
 * Class NotEnoughMoney exception.
 * @author vivanov
 * @version 1
 * @since 06.01.2018
 */
public class NotEnoughMoney extends RuntimeException {

    /**
     * Class NotEnoughMoney constructor.
     * @param msg - message to print when exception occurs
     */
    public NotEnoughMoney(String msg) {
        super(msg);
    }
}
