package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(String type, String color, int row, int col, Board board) {
        super(type, color, row, col, board);
    }

    @Override
    public List<String> possibleMoves() {
        List<String> movesList = new ArrayList<>();

        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(i!=0 && j!=0){
                    Piece temp = board.getPiece(row+i, col+j);
                    if(temp!=null){
                        if(!this.sameColor(temp)){
                            movesList.add(row+ String.valueOf(col) + (row+i) + (col+j) + temp.getType());
                        }
                    }
                    movesList.add(row+ String.valueOf(col) + (row+i) + (col+j) + "E");
                }
            }
        }
        return movesList;
    }
}
