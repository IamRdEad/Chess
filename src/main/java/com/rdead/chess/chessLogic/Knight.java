package com.rdead.chess.chessLogic;

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
                movesList.add(row + String.valueOf(col) + newRow + newCol + "E");
            }
            else{
                if(!(this.sameColor(temp))){
                    movesList.add(row + String.valueOf(col) + newRow + newCol + temp.getType());
                }
            }
        }
        return movesList;
    }
}
