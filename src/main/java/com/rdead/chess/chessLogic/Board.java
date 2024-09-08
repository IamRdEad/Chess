package com.rdead.chess.chessLogic;

import com.rdead.chess.chessLogic.Pieces.*;

public class Board {

    private Piece[][] board;
    private final int LEN = 8;

    public void makeMove(String move){
        int row = Character.getNumericValue(move.charAt(0));
        int col = Character.getNumericValue(move.charAt(1));
        int newRow = Character.getNumericValue(move.charAt(2));
        int newCol = Character.getNumericValue(move.charAt(3));

        this.board[newRow][newCol] = this.board[row][col];
        this.board[row][col] = null;
    }

    public void undoMove(String move, Piece piece){

        this.board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] =
                this.board[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))];
        this.board[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))] = piece;
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

    public Board(int code){
        String[][] stringBoard = getBoard(code);
        board = new Piece[LEN][LEN];
        fillBoard(stringBoard);
    }

    private String[][] getBoard(int code){
        if(code==1){
            return new String[][]{
                    {"R", "N", "B", "Q", "K", "B", "N", "R"},
                    {"P", "P", "P", "P", "P", "P", "P", "P"},
                    {" ", " ", " ", " ", " ", " ", " ", " "},
                    {" ", " ", " ", " ", " ", " ", " ", " "},
                    {" ", " ", " ", " ", " ", " ", " ", " "},
                    {" ", " ", " ", " ", " ", " ", " ", " "},
                    {"p", "p", "p", "p", "p", "p", "p", "p"},
                    {"r", "n", "b", "q", "k", "b", "n", "r"}
            };
        }
        return null;
    }

    private void fillBoard(String[][] stringBoard){
        for(int i=0; i<LEN; i++){
            for(int j=0; j<LEN; j++){
                switch (stringBoard[i][j]){
                    case "p":
                        Piece wp = new Pawn("p","white",i,j, this);
                        this.board[i][j] = wp;
                        break;
                    case "P":
                        Piece bp = new Pawn("P","black",i,j, this);
                        this.board[i][j] = bp;
                        break;
                    case "r":
                        Piece wr = new Pawn("r","white",i,j,this);
                        this.board[i][j] = wr;
                        break;
                    case "R":
                        Piece br = new Pawn("R","black",i,j,this);
                        this.board[i][j] = br;
                        break;
                    case "n":
                        Piece wn = new Knight("n","white",i,j,this);
                        this.board[i][j] = wn;
                        break;
                    case "N":
                        Piece bn = new Knight("N","black",i,j,this);
                        this.board[i][j] = bn;
                        break;
                    case "b":
                        Piece wb = new Pawn("b","white",i,j,this);
                        this.board[i][j] = wb;
                        break;
                    case "B":
                        Piece bb = new Pawn("B","black",i,j,this);
                        this.board[i][j] = bb;
                        break;
                    case "q":
                        Piece wq = new Pawn("q","white",i,j,this);
                        this.board[i][j] = wq;
                        break;
                    case "Q":
                        Piece bq = new Pawn("Q","black",i,j,this);
                        this.board[i][j] = bq;
                        break;
                    case "k":
                        Piece wk = new Pawn("k","white",i,j,this);
                        this.board[i][j] = wk;
                        break;
                    case "K":
                        Piece bk = new Pawn("K","black",i,j,this);
                        this.board[i][j] = bk;
                        break;
                    default:
                        this.board[i][j] = null;
                }
            }
        }
    }
}
