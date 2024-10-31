package com.assignment.tictactoe.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Appinitlizer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent load = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        Image image = new Image(getClass().getResourceAsStream("/image/Screenshot 2024-10-15 161737.png"));
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();
    }
}
