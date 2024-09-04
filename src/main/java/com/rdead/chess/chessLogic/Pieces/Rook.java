package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(String type, String color, int row, int col, Board board) {
        super(type, color, row, col, board);
    }

    @Override
    public List<String> possibleMoves() {
        List<String> movesList = new ArrayList<>();

        // Check horizontal and vertical directions
        for (int dir = -1; dir <= 1; dir += 2) {
            // Horizontal moves (left and right)
            for (int mul = 1; mul < 8; mul++) {
                int newRow = this.row + (dir * mul);
                if (checkLine(movesList, newRow, this.col)) break;
            }
            // Vertical moves (up and down)
            for (int mul = 1; mul < 8; mul++) {
                int newCol = this.col + (dir * mul);
                if (checkLine(movesList, this.row, newCol)) break;
            }
        }

        return movesList;
    }

    private boolean checkLine(List<String> movesList, int newRow, int newCol) {
        if (!this.inBoard(newRow, newCol)) {
            return true;
        }
        Piece temp = board.getPiece(newRow, newCol);
        if (temp == null) {
            String move = this.row + String.valueOf(this.col) + newRow + newCol + "E";
            if(KingSafe.kingSafe(this.board, this.color, move)){
                movesList.add(move);
            }
        } else {
            if (!this.sameColor(temp)) {
                String move = this.row + String.valueOf(this.col) + newRow + newCol + temp.getType();
                if(KingSafe.kingSafe(this.board, this.color, move)){
                    movesList.add(move);
                }
            }
            return true;
        }
        return false;
    }

}
