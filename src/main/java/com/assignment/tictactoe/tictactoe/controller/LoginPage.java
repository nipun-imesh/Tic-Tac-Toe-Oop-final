package com.assignment.tictactoe.tictactoe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class LoginPage {

    @FXML
    private AnchorPane ANKmainpage;

    @FXML
    private Button BUTstart;

    @FXML
    private TextField TXTName;

    @FXML
    void goPLayPageActoiuin(ActionEvent event) throws IOException {
        ANKmainpage.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/PlayProfilePage.fxml"));
        ANKmainpage.getChildren().add(load);
    }

}
