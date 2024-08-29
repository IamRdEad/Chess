package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(String type, String color, int row, int col, Board board) {
        super(type, color, row, col, board);
    }

    @Override
    public List<String> possibleMoves() {
        List<String> movesList = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                try {
                    Piece temp = board.getPiece(row + i, col + j);
                    if (temp == null) {
                        movesList.add(row + String.valueOf(col) + (row + i) + (col + j) + "E");
                    } else if (!this.sameColor(temp)) {
                        movesList.add(row + String.valueOf(col) + (row + i) + (col + j) + temp.getType());
                    }

                } catch (Exception ignored) {
                }
                ;
            }
        }
        return movesList;
    }
}
