package com.example.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

import java.security.Key;

public class Oiseaux {

    public Oiseaux() {


    }

    public Group creerOiseaux(int x, int y) {
        QuadCurve aile1 = new QuadCurve(x, y, x - 25, y - 25, x - 50, y);
        aile1.setStroke(Color.BLACK);
        aile1.setFill(Color.TRANSPARENT);
        QuadCurve aile2 = new QuadCurve(x, y, x + 25, y - 25, x + 50, y);
        aile2.setStroke(Color.BLACK);
        aile2.setFill(Color.TRANSPARENT);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyValue debutAile1 = new KeyValue(aile1.startYProperty(), y + 10);
        KeyFrame kfMidBird1 = new KeyFrame(Duration.seconds(1), debutAile1);
        KeyValue debutAile2 = new KeyValue(aile2.startYProperty(), y + 10);
        KeyFrame kfMidBird2 = new KeyFrame(Duration.seconds(1), debutAile2);

        KeyValue finAile1 = new KeyValue(aile1.endYProperty(), y - 20);
        KeyFrame kfTipBird1 = new KeyFrame(Duration.seconds(1), finAile1);

        KeyValue finAile2 = new KeyValue(aile2.endYProperty(), y - 20);
        KeyFrame kfTipBird2 = new KeyFrame(Duration.seconds(1), finAile2);


        timeline.getKeyFrames().addAll(kfMidBird1, kfMidBird2, kfTipBird1, kfTipBird2);
        timeline.setAutoReverse(true);
        timeline.play();
        return new Group(aile1, aile2);
    }


}
