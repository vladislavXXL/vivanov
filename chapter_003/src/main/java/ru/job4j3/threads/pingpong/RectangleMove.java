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
        boolean isBorder = false;
        while (true) {
            if (!isBorder) {
                this.rect.setX(this.rect.getX() + 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.rect.getX() == 300) {
                    isBorder = true;
                }
            }
            while (isBorder) {
                this.rect.setX(this.rect.getX() - 1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.rect.getX() == 0) {
                    isBorder = false;
                }
            }
        }
    }
}
