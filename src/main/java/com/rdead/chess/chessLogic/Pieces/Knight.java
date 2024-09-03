package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    public Knight(String type, String color, int row, int col, Board board) {
        super(type, color, row, col, board);
    }

    @Override
    public List<String> possibleMoves() {
        List<String> movesList = new ArrayList<>();
        //all possible direction for a night
        int[][] moves = {
                {-1,-2}, {-1,2}, {1,-2}, {1,2},
                {-2,-1}, {-2,1},{ 2,-1}, {2,1}
        };

        for(int[] move: moves){
            int newRow = this.row+move[0];
            int newCol = this.col+move[1];
            if(!inBoard(newRow, newCol)){
                continue;
            }
            Piece temp=board.getPiece(newRow, newCol);
            if(temp == null){
                String newMove = row + String.valueOf(col) + newRow + newCol + "E";
                if(KingSafe.kingSafe(board, this.color, newMove)){
                    movesList.add(newMove);
                }

            }
            else{
                if(!(this.sameColor(temp))){
                    String newMove = row + String.valueOf(col) + newRow + newCol + temp.getType();
                    KingSafe.kingSafe(board, this.color, newMove);
                    movesList.add(newMove);
                }
            }
        }
        return movesList;
    }
}
