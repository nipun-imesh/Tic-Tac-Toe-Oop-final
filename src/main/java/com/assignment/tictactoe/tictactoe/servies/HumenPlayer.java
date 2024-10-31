package com.assignment.tictactoe.tictactoe.servies;

public class HumenPlayer extends Player{

    public HumenPlayer(BoardImpl board) {
        super(board);
    }

    @Override
    public void move(int row, int col) {
        if(board.isLegalMove(row, col)){
            board.updateMove(row, col, Piece.X);
            board.printBoard();
        }
    }

}
