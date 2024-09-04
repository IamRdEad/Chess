package com.rdead.chess;

import com.rdead.chess.chessLogic.Board;
import com.rdead.chess.chessLogic.Pieces.King;
import com.rdead.chess.chessLogic.Pieces.Piece;
import com.rdead.chess.chessLogic.Pieces.Rook;

import java.util.ArrayList;
import java.util.Arrays;


//@SpringBootApplication
public class ChessApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ChessApplication.class, args);
        Piece[][] board = new Piece[8][8];
        Board b = new Board(board);

        Rook br = new Rook("R", "black", 7, 0, b);
        Rook wr = new Rook("r", "white", 7, 5, b);
        King wk = new King("k", "white", 7, 6 ,b);

        b.printBoard();
        System.out.println(Arrays.toString(wr.possibleMoves().toArray()));
    }
}
