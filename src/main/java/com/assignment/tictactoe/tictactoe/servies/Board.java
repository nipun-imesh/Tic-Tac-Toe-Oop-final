package com.assignment.tictactoe.tictactoe.servies;

public interface Board {
    BoardUI getBoardUI();

    void initializeBoard();

    boolean isLegalMove(int row, int col);

    void updateMove(int row, int col, Piece piece);

    Winner checkWinner();

    void printBoard();

}

