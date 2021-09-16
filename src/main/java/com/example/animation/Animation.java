package com.example.animation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Animation extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Animation");
        stage.setResizable(false);
        stage.setWidth(1000);
        stage.setHeight(500);

        Ciel ciel = new Ciel();
        Maison maison = new Maison();
        Etoiles etoiles = new Etoiles();


        Group maisons = new Group(maison.creerMaison(200,300), maison.creerMaison(700,300));
        Group root = new Group(ciel.creerCiel(), maisons);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}