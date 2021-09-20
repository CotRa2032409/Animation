package com.example.animation;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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

        Circle soleil = new Circle(x, y, 30);
        soleil.setFill(Color.YELLOW);


        Line grandRayon1 = new Line(x, y - 40, x, y - 100);
        grandRayon1.setStroke(Color.YELLOW);

        Line grandRayon2 = new Line(x + 40, y, x + 100, y);
        grandRayon2.setStroke(Color.YELLOW);

        Line grandRayon3 = new Line(x, y + 40, x, y + 100);
        grandRayon3.setStroke(Color.YELLOW);

        Line grandRayon4 = new Line(x - 40, y, x - 100, y);
        grandRayon4.setStroke(Color.YELLOW);

        Line petitRayon1 = new Line(x + 30, y - 30, x + 60, y - 60);
        petitRayon1.setStroke(Color.YELLOW);

        Line petitRayon2 = new Line(x + 30, y + 30, x + 60, y + 60);
        petitRayon2.setStroke(Color.YELLOW);

        Line petitRayon3 = new Line(x - 30, y + 30, x - 60, y + 60);
        petitRayon3.setStroke(Color.YELLOW);

        Line petitRayon4 = new Line(x - 30, y - 30, x - 60, y - 60);
        petitRayon4.setStroke(Color.YELLOW);

        Group rayons = new Group(grandRayon1, grandRayon2, grandRayon3, grandRayon4, petitRayon1, petitRayon2, petitRayon3, petitRayon4);
        RotateTransition rotation = new RotateTransition(Duration.seconds(5), rayons);
        rotation.setByAngle(360);
        rotation.setCycleCount(Timeline.INDEFINITE);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.play();

        FillTransition couleur = new FillTransition(Duration.seconds(3), soleil);
        couleur.setToValue(Color.ORANGE);
        couleur.setCycleCount(Timeline.INDEFINITE);
        couleur.setAutoReverse(true);
        couleur.play();


        return new Group(soleil, rayons);
    }


    public Group creerLune(int x, int y) {

        Circle lune = new Circle(x, y, 30);
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
