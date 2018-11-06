package ru.job4j3.threads.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Class PingPong.
 * @author v.ivanov
 * @version 1
 * @since 25.10.2018
 */
public class PingPong extends Application {

    /** Field program title.*/
    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    /**
     * Entry point to the thread.
     * @param stage - program stage
     */
    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        group.getChildren().add(rect);
        new Thread(new RectangleMove(rect)).start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
    }
}
