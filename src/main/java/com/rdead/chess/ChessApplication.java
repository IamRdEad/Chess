package com.rdead.chess;

import com.rdead.chess.chessLogic.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ChessApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ChessApplication.class, args);
        Piece[][] board = new Piece[8][8];
        Board b = new Board(board);
        Piece r1 = new Rook("r","white", 4, 3, b);
        Piece p1 = new Pawn("p", "white", 2, 3, b);
        Piece p2 = new Pawn("P", "black", 4, 5, b);
        Piece p3 = new Pawn("p", "white", 4, 1, b);
        Piece p4 = new Pawn("p", "white", 6, 3, b);
        System.out.println("the possible moves are: " + r1.possibleMoves());
    }
}
