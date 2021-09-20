package com.example.animation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;


public class Animation extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Animation");
        stage.setResizable(false);
        stage.setWidth(1000);
        stage.setHeight(500);

        //Ciel
        Ciel ciel = new Ciel();

        //Maisons
        Maison maison1 = new Maison(200, 300);
        Maison maison2 = new Maison(700, 300);
        maison1.dropShadowMaison();

        //Création des étoiles
        Polygon etoile1 = Etoiles.creerEtoiles(550, 40, 1.5);
        Polygon etoile2 = Etoiles.creerEtoiles(630, 70, 2);
        Polygon etoile3 = Etoiles.creerEtoiles(700, 57, 3);
        Polygon etoile4 = Etoiles.creerEtoiles(750, 80, 4);

        //Modification des étoiles
        etoile3.setScaleY(0.7);
        etoile3.setScaleX(0.7);
        etoile2.setRotate(46);
        etoile2.setScaleX(1.15);
        etoile2.setScaleY(1.15);
        etoile4.setRotate(-19);

        //Lune
        Etoiles lune = new Etoiles();

        //Oiseaux
        Oiseaux oiseau1 = new Oiseaux();
        Oiseaux oiseau2 = new Oiseaux();

        //Soleil
        Etoiles soleil = new Etoiles();

        Group maisons = new Group(maison1, maison2);
        Group etoiles = new Group(etoile1, etoile2, etoile3, etoile4, lune.creerLune(900, 80), soleil.creerSoleil(400, 100));
        Group oiseaux = new Group(oiseau1.creerOiseaux(100, 200), oiseau2.creerOiseaux(250, 150));
        Group root = new Group(ciel.creerCiel(), maisons, etoiles, oiseaux);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}