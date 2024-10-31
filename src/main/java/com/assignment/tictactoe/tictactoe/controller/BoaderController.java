package com.assignment.tictactoe.tictactoe.controller;

import com.assignment.tictactoe.tictactoe.servies.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


public class BoaderController implements BoardUI {
    private HumenPlayer humanPlayer;
    private AIPlayer aiPlayer;
    BoardImpl board;

    public BoaderController() {
        board = new BoardImpl(this);
        humanPlayer = new HumenPlayer(board);
        aiPlayer = new AIPlayer(board);
    }

    @FXML
    private AnchorPane ANKpalyPage;

    @FXML
    private Button BUT1;

    @FXML
    private Button BUT2;

    @FXML
    private Button BUT3;

    @FXML
    private Button BUT4;

    @FXML
    private Button BUT5;

    @FXML
    private Button BUT6;

    @FXML
    private Button BUT7;

    @FXML
    private Button BUT8;

    @FXML
    private Button BUT9;

    @FXML
    private Label LBwiningtag;

    @FXML
    private Button BUTrestart;



    @FXML
    void butOnaction(ActionEvent event) {

        Button but = (Button) event.getSource();
        if(!but.getText().isEmpty()){
           // new Alert(Alert.AlertType.INFORMATION, "Already Selected this button").showAndWait();
            return;
        }
        int call = Integer.parseInt(but.getId().substring(3));
        System.out.println(call);

        int count = 1;
        L1:for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (count == call) {
                    humanPlayer.move(i, j);
                    update(i, j, Piece.X);
                    aiPlayer.findBestMove();

                    if(board.checkWinner() != null){
                        notifyWinner(board.checkWinner().getWinningPiece());
                    }else if(board.isBoardFull()){
                        new Alert(Alert.AlertType.INFORMATION, "Drow").showAndWait();
                    }
                    break L1;
                }
                count++;
            }
        }
    }

    @FXML
    void reStartaction(ActionEvent event) {
        try {
            ANKpalyPage.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/PlayProfilePage.fxml"));
            ANKpalyPage.getChildren().add(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int row, int col, Piece piece) {
        Button[][] buttons = {{BUT1, BUT2, BUT3}, {BUT4, BUT5, BUT6}, {BUT7, BUT8, BUT9}};
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (i == row && j == col) {
                    if (piece == Piece.X) {
                        buttons[row][col].setText("X");
                    } else if (piece == Piece.O) {
                        buttons[row][col].setText("O");
                    } else {
                        buttons[row][col].setText("");
                    }
                }
            }
        }
    }

    @Override
    public void notifyWinner(Piece winner) {
        if(Piece.X == board.checkWinner().getWinningPiece()){
            colorsetwinner( board.checkWinner());
            new Alert(Alert.AlertType.INFORMATION,  "YOU Win").showAndWait();
        }else if(Piece.O == board.checkWinner().getWinningPiece()){
            colorsetwinner( board.checkWinner());
            new Alert(Alert.AlertType.INFORMATION, "AI Win").showAndWait();
        }
    }
    private void colorsetwinner(Winner winner){
        Button [][] buttons = {{BUT1, BUT2, BUT3}, {BUT4, BUT5, BUT6}, {BUT7, BUT8, BUT9}};

        int [] row = {winner.getRow1(), winner.getRow2(), winner.getRow3()};
        int [] col = {winner.getCol1(), winner.getCol2(), winner.getCol3()};
        for (int i = 0; i < row.length; i++) {
            buttons[row[i]][col[i]].setStyle("-fx-background-color: linear-gradient(to bottom , #FF6F61, #FF4C6D);-fx-text-fill: linear-gradient(to bottom, #D2FF72, #76FF03);");
        }
    }
}
