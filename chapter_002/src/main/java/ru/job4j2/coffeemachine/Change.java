package ru.job4j2.coffeemachine;

import ru.job4j2.coffeemachine.changeexceptions.NotEnoughMoney;

/**
 * Class Change to calculate value of change.
 * @author vivanov
 * @version 1
 * @since 06.01.2018
 */
public class Change {

    /** array of available notes values. */
    private int[] notes = {10, 5, 2, 1};

    /**
     * Method changes is used to calculate the value of giving back change and amount of a notes from coffee machine.
     * @param value - value of a giving note to the coffee machine
     * @param price - price of the coffee
     * @return result array with notes value.
     */
    public int[] changes(int value, int price) {

        if (value < price) {
            throw new NotEnoughMoney("Money is not enough to buy this coffee.");
        }

        int changeAmount = value - price;
        int inc = 0;
        double nod = 0;
        int index = 0;

        int[] arr = new int[1];

        while (changeAmount > 0) {

            double minNod = Double.POSITIVE_INFINITY;
            for (int i = 0; i < this.notes.length; i++) {
                nod = changeAmount / (double) this.notes[i];
                if (nod < minNod && nod >= 1) {
                    index = i;
                    minNod = nod;
                }
            }

            int[] arrA = {this.notes[index]};
            int[] arrB = new int[inc + 1];
            System.arraycopy(arr, 0, arrB, 0, inc + 1);
            arr = new int[arrB.length + 1];
            System.arraycopy(arrB, 0, arr, 0, arrB.length);
            System.arraycopy(arrA, 0, arr, inc, 1);
            inc++;
            changeAmount -= this.notes[index];
        }

        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, arr.length - 1);

        return result;
    }
}