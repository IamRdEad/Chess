package com.rdead.chess.chessLogic;

import com.rdead.chess.chessLogic.Pieces.Piece;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Board {

    private Piece[][] board;

    public void makeMove(int row, int col, int newRow, int newCol){
        this.board[newRow][newCol] = this.board[row][col];
        this.board[row][col] = null;
    }

    public void setPiece(Piece p){
        board[p.getRow()][p.getCol()]=p;
    }

    public Piece getPiece(int row, int col){
        return board[row][col];
    }

    public void printBoard(){
        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                if (piece == null)
                    System.out.print(" ");
                else {
                    System.out.print(piece.getType());
                }
            }
            System.out.println();
        }
    }

    public String[][] boardToSting(){
        String[][] stringBoard = new String[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                stringBoard[i][j] = board[i][j]==null? " " : board[i][j].getType();
            }
        }
        return stringBoard;
    }
}
