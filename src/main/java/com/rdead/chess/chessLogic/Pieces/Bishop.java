package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(String type, String color, int row, int col, Board board) {
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
            String move = this.row + String.valueOf(this.col) + newRow + newCol + (temp == null ? "E" : temp.getType());
            if (temp == null) {
                if (KingSafe.kingSafe(this.board, this.color, move)) {
                    movesList.add(move);
                }
            } else {
                if (!this.sameColor(temp) && KingSafe.kingSafe(this.board, this.color, move)) {
                    movesList.add(move);
                }
                break;
            }
        }
    }
}