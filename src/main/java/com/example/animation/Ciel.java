package com.example.animation;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Ciel {

    public Ciel() {
    }

    public Group creerCiel() {
        Rectangle jour = new Rectangle(0, 0, 500, 500);
        jour.setFill(Color.LIGHTGREY);
        Rectangle nuit = new Rectangle(500, 0, 500, 500);
        nuit.setFill(Color.BLACK);

        Text textJour = new Text(200, 420, "Jour");
        textJour.setFont(new Font("Jour", 50));

        Text textNuit = new Text(700, 420, "Nuit");
        textNuit.setFont(new Font("Nuit", 50));
        textNuit.setFill(Color.WHITE);

        return new Group(jour, nuit, textJour, textNuit);
    }
}
