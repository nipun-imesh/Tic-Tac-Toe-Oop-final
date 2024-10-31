package com.assignment.tictactoe.tictactoe.servies;

public interface BoardUI {


    void update(int row, int col, Piece piece);
    void notifyWinner(Piece winner);
}
