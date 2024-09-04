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
                int newRow = row + i;
                int newCol = col + j;
                if (!inBoard(newRow, newCol)) {
                    continue;
                }
                Piece temp = board.getPiece(newRow, newCol);
                String move = row + String.valueOf(col) + newRow + newCol + (temp == null ? "E" : temp.getType());
                if (KingSafe.kingSafe(this.board, this.color, move)) {
                    movesList.add(move);
                }
            }
        }
        return movesList;
    }
}
