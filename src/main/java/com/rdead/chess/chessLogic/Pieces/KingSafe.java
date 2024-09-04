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

        //check if king is safe
        boolean flag = checkLines(row, col, color, b) && checkDiag(row, col, color, b)
                        && checkKnight(row, col, color, b) && checkPawn(row, col, color, b);

        //undoMove
        b.undoMove(move, piece);
        return flag;
    }

    private static boolean checkLines(int row, int col, String color, Board board) {

        // Check left
        for (int c = col - 1; c >= 0; c--) {
            Piece piece = board.getPiece(row, c);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("R") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }

        // Check right
        for (int c = col + 1; c < 8; c++) {
            Piece piece = board.getPiece(row, c);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("R") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }

        // Check up
        for (int r = row - 1; r >= 0; r--) {
            Piece piece = board.getPiece(r, col);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("R") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }

        // Check down
        for (int r = row + 1; r < 8; r++) {
            Piece piece = board.getPiece(r, col);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("R") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }

        return true;
    }


    private static boolean checkDiag(int row, int col, String color, Board board) {
        // Check top-left
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            Piece piece = board.getPiece(r, c);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("B") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }

        // Check top-right
        for (int r = row - 1, c = col + 1; r >= 0 && c < 8; r--, c++) {
            Piece piece = board.getPiece(r, c);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("B") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }

        // Check bottom-left
        for (int r = row + 1, c = col - 1; r < 8 && c >= 0; r++, c--) {
            Piece piece = board.getPiece(r, c);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("B") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }

        // Check bottom-right
        for (int r = row + 1, c = col + 1; r < 8 && c < 8; r++, c++) {
            Piece piece = board.getPiece(r, c);
            if (piece != null) {
                if (!piece.getColor().equals(color) && (piece.getType().equals("B") || piece.getType().equals("Q"))) {
                    return false;
                }
                break;
            }
        }
        return true;
    }




    private static boolean checkKnight(int row, int col, String color, Board board) {
        // Possible knight moves (rowOffset, colOffset)
        int[][] knightMoves = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}
        };

        for (int[] move : knightMoves) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                Piece piece = board.getPiece(newRow, newCol);
                if (piece != null && !piece.getColor().equals(color) && piece.getType().equals("N")) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean checkPawn(int row, int col, String color, Board board) {
        // Check if the king is white or black
        int direction = color.equals("white") ? -1 : 1;  // White pawns move upwards (-1), black downwards (+1)

        int[] colOffsets = {-1, 1};

        for (int colOffset : colOffsets) {
            int newRow = row + direction;
            int newCol = col + colOffset;

            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                Piece piece = board.getPiece(newRow, newCol);
                if (piece != null && !piece.getColor().equals(color) && piece.getType().equals("P")) {
                    return false;
                }
            }
        }
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
