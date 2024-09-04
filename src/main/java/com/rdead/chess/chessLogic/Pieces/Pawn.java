package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(String type, String color, int row, int col, Board board){
        super(type, color, row, col, board);
    }

    @Override
    public List<String> possibleMoves() {
        List<String> movesList = new ArrayList<>();

        // white pawn moves up (so row number gets smaller), black pawn vice versa
        int dir = color.equals("white") ? -1 : 1;
        int firstRow = color.equals("white") ? 6 : 1; // in 2D array pawn starts in row 6 for white and 1 for black

        if (board.getPiece(row + dir, col) == null) { // check if you can move 1 step forward
            String move = row + String.valueOf(col) + (row + dir) + col + "E";
            if (KingSafe.kingSafe(board, this.color, move)) {
                movesList.add(move);
            }
        }

        // only in the first row you can move 2 forward
        if (row == firstRow) {
            if (board.getPiece(row + dir, col) == null && board.getPiece(row + (dir * 2), col) == null) {
                String move = row + String.valueOf(col) + (row + (dir * 2)) + col + "E";
                if (KingSafe.kingSafe(board, this.color, move)) {
                    movesList.add(move);
                }
            }
        }

        // pawn can eat only diagonally and only if there is a piece
        if (col < 7) {
            Piece temp = board.getPiece(row + dir, col + 1);
            if ((temp != null) && !(this.sameColor(temp))) {
                String captureMove = row + String.valueOf(col) + (row + dir) + (col + 1) + temp.getType();
                if (KingSafe.kingSafe(board, this.color, captureMove)) {
                    movesList.add(captureMove);
                }
            }
        }

        if (col > 0) {
            Piece temp = board.getPiece(row + dir, col - 1);
            if ((temp != null) && !(this.sameColor(temp))) {
                String captureMove = row + String.valueOf(col) + (row + dir) + (col - 1) + temp.getType();
                if (KingSafe.kingSafe(board, this.color, captureMove)) {
                    movesList.add(captureMove);
                }
            }
        }

        // TODO! -- implement promotion when reaching the other side of the board

        return movesList;
    }
}
