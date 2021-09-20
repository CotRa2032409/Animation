package com.example.animation;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Etoiles {

    public Etoiles() {
    }

    public static Polygon creerEtoiles(int midX, int midY, double duree) {


        int radius[] = {20, 8, 20, 8};
        int nPoints = 10;
        int max = 5;
        double[] X = new double[nPoints];
        double[] Y = new double[nPoints];
        Polygon etoile1 = new Polygon();
        for (double current = 0.0; current < nPoints; current++) {
            int i = (int) current;
            double x = Math.cos(current * ((2 * Math.PI) / max)) * radius[i % 4];
            double y = Math.sin(current * ((2 * Math.PI) / max)) * radius[i % 4];

            X[i] = (int) x + midX;
            Y[i] = (int) y + midY;
            etoile1.getPoints().add(X[i]);
            etoile1.getPoints().add(Y[i]);
        }
        etoile1.setFill(Color.YELLOW);
        etoile1.setStroke(Color.YELLOW);
        FadeTransition fade = new FadeTransition(Duration.seconds(duree), etoile1);
        fade.setFromValue(1.0);
        fade.setToValue(0);
        fade.setCycleCount(Timeline.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        return etoile1;
    }

    public Group creerSoleil(int x, int y) {

        return new Group();
    }

    public Group creerLune(int x, int y, int rayon) {

        Circle lune = new Circle(x, y, rayon);
        lune.setFill(Color.WHITE);

        Stop[] stops = new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(1, Color.BLACK),
        };

        LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);

        lune.setFill(gradient);


        return new Group(lune);
    }

}
