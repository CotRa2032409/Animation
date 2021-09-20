package com.example.animation;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Maison extends Group {

    public Maison(int x, int y) {
        Rectangle murs = new Rectangle(x, y, 100, 75);
        murs.setFill(Color.BEIGE);

        getChildren().addAll(murs, creerFenetre(x, y), creerPorte(x, y), creerToit(x, y));
    }



    public Group creerFenetre(int x, int y) {
        Rectangle fenetre = new Rectangle(x + 60, y + 15, 30, 20);
        fenetre.setFill(Color.AQUA);
        fenetre.setStrokeWidth(3);
        fenetre.setStroke(Color.LIGHTBLUE);
        fenetre.setOpacity(0.75);

        Line vertical = new Line(x + 75, y + 15, x + 75, y + 35);
        vertical.setStroke(Color.LIGHTBLUE);
        vertical.setStrokeWidth(3);
        vertical.setOpacity(0.75);

        Line horizontal = new Line(x + 60, y + 25, x + 90, y + 25);
        horizontal.setStroke(Color.LIGHTBLUE);
        horizontal.setStrokeWidth(3);
        horizontal.setOpacity(0.75);
        Group groupFenetre = new Group(fenetre, horizontal, vertical);
        return groupFenetre;
    }

    public Group creerPorte(int x, int y) {
        Rectangle porte = new Rectangle(x + 20, y + 35, 25, 40);
        porte.setFill(Color.SADDLEBROWN);
        Arc poignee = new Arc(x + 39, y + 55, 5, 5, 0, 360);
        poignee.setFill(Color.YELLOWGREEN);

        return new Group(porte, poignee);
    }

    public Group creerToit(int x, int y) {
        Polygon toit = new Polygon(x, y, x + 100, y, x + 50, y - 50);
        toit.setFill(Color.BROWN);

        return new Group(toit);
    }

    public void dropShadowMaison() {

        DropShadow ds = new DropShadow(10,-10,10, Color.GRAY);
        GaussianBlur blur = new GaussianBlur(10);
        setEffect(blur);
        setEffect(ds);
    }
}
