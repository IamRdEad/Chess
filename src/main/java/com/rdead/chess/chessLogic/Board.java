package com.rdead.chess.chessLogic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Board {

    private Piece[][] board;

    public void updateBoard(int row, int col, int newRow, int newCol){
        this.board[newRow][newCol] = this.board[row][col];
        this.board[row][col] = null;
    }

    public void setPiece(Piece p){
        board[p.getRow()][p.getCol()]=p;
    }

    public Piece getPiece(int row, int col){
        return board[row][col];
    }
}
