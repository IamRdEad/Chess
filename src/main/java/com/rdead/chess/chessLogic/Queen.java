package com.rdead.chess.chessLogic;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
    public Queen(String type, String color, int row, int col, Board board) {
        super(type, color, row, col, board);
    }

    @Override
    public List<String> possibleMoves() {
        List<String> movesList = new ArrayList<>();

        // Check all four possible diagonal directions for the bishop
        checkDiagonal(movesList, 1, 1);
        checkDiagonal(movesList, 1, -1);
        checkDiagonal(movesList, -1, 1);
        checkDiagonal(movesList, -1, -1);

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

    private void checkDiagonal(List<String> movesList, int rowIncrement, int colIncrement) {
        for (int mul = 1; mul < 8; mul++) {
            int newRow = this.row + rowIncrement * mul;
            int newCol = this.col + colIncrement * mul;

            if (!this.inBoard(newRow, newCol)) {
                break;
            }

            Piece temp = board.getPiece(newRow, newCol);
            if (temp == null) {
                movesList.add(this.row + String.valueOf(this.col) + newRow + newCol + "E");
            } else {
                if (!this.sameColor(temp)) {
                    movesList.add(this.row + String.valueOf(this.col) + newRow + newCol + temp.getType());
                }
                break;
            }
        }
    }

    private boolean checkLine(List<String> movesList, int newRow, int newCol) {
        if (!this.inBoard(newRow, newCol)) {
            return true;
        }
        Piece temp = board.getPiece(newRow, newCol);
        if (temp == null) {
            movesList.add(this.row + String.valueOf(this.col) + newRow + newCol + "E");
        } else {
            if (!this.sameColor(temp)) {
                movesList.add(this.row + String.valueOf(this.col) + newRow + newCol + temp.getType());
            }
            return true;
        }
        return false;
    }
}
