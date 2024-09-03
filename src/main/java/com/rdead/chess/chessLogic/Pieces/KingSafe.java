package com.rdead.chess.chessLogic.Pieces;

import com.rdead.chess.chessLogic.Board;

public class KingSafe {

    public static boolean kingSafe(Board b, String color, String move){

        //find king position
        int[] kingPos = kingPosition(b,color);
        int row = kingPos[0];
        int col = kingPos[1];

        //make the move
        Piece piece = b.getPiece(Character.getNumericValue(move.charAt(2)), Character.getNumericValue(move.charAt(3)));
        b.makeMove(move);
        b.printBoard();
        //check if king is safe
        boolean flag = checkLines() && checkDiag() && checkKnight() && checkPawn();

        //undoMove
        b.undoMove(move, piece);
        b.printBoard();
        return flag;
    }

    private static boolean checkDiag(){

        return true;
    }

    private static boolean checkLines(){

        return true;
    }

    private static boolean checkKnight(){

        return true;
    }

    private static boolean checkPawn(){

        return true;
    }

    private static int[] kingPosition(Board board, String color){
        int[] pos = new int[2];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Piece piece = board.getPiece(i, j);
                if(piece!=null){
                    String pieceType = piece.getType().toLowerCase();
                    String pieceColor = piece.getColor();
                    if(pieceType.equals("k") && pieceColor.equals(color)){
                        pos[0] = i;
                        pos[1] = j;
                        break;
                    }
                }
            }
        }
        return pos;
    }
}
