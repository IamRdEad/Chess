package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;

import java.util.List;

public abstract  class Piece {
    protected String type;
    protected String color;
    protected int row;
    protected int col;
    protected Board board;

    public Piece(String type, String color, int row, int col, Board board) {
        this.type = type;
        this.color = color;
        this.row = row;
        this.col = col;
        this.board = board;
        board.setPiece(this);
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Board getBoard() {
        return board;
    }

    public abstract List<String> possibleMoves();

    public boolean inBoard(int newRow, int newCol){
        return !(newRow<0 || newRow>7 || newCol<0 || newCol>7);
    }

    public boolean sameColor(Piece other){
        return this.color.equals(other.color);
    }
}
