package com.assignment.tictactoe.tictactoe.servies;

public abstract class Player {
    protected BoardImpl board;
    public Player(BoardImpl board) {
        this.board = board;
    }

    public abstract void move(int row, int col);
}
