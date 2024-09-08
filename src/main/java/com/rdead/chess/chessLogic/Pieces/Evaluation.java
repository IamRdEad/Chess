package com.rdead.chess.chessLogic.Pieces;

public class Evaluation {
    public static int evalBoard(String color, Piece[][] board){
        int score = 0;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null) {
                    int pieceValue = getPieceValue(piece);
                    score += piece.getColor().equals(color) ? pieceValue : -pieceValue;
                }
            }
        }

        return score;
    }

    private static int getPieceValue(Piece piece) {
        return switch (piece.getType()) {
            case "p" -> 1;
            case "n", "b" -> 3;
            case "r" -> 5;
            case "q" -> 9;
            case "k" -> Integer.MAX_VALUE;
            default -> 0;
        };
    }
}
