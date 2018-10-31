package ru.job4j3.threads.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private boolean isBorder;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
        this.isBorder = false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!this.isBorder) {
                    synchronized (this.rect) {
                        this.rect.setX(this.rect.getX() + 1);
                        if (this.rect.getX() == 300) {
                            this.isBorder = true;
                            synchronized (this) {
                                while (this.isBorder) {
                                    backMove();
                                    wait();
                                }
                            }
                        }
                    }
                }
                Thread.sleep(50);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    synchronized void backMove() {
        try {
            while (true) {
                if (this.isBorder) {
                    synchronized (this.rect) {
                        this.rect.setX(this.rect.getX() - 1);
                        if (this.rect.getX() == 0) {
                            this.isBorder = false;
                            run();
                            wait();
                        }
                    }
                }
                Thread.sleep(50);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
