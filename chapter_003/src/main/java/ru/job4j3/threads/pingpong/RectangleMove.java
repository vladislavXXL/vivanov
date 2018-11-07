package ru.job4j3.threads.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove.
 * @author v.ivanov
 * @version 1
 * @since 06.11.2018
 */
public class RectangleMove implements Runnable {

    /** Field rectangle.*/
    private final Rectangle rect;

    /**
     * Class RectangleMove constructor.
     * @param rect - rectangle instance
     */
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    /**
     * Method run implements thread.
     */
    @Override
    public void run() {
        int delta = 1;
        while (true) {
            if (this.rect.getX() >= 300 || this.rect.getX() <= 0) {
                delta *= -1;
            }
            this.rect.setX(this.rect.getX() + delta);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
