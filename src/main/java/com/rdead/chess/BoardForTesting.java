package com.rdead.chess;

import com.rdead.chess.chessLogic.*;
import com.rdead.chess.chessLogic.Pieces.*;


public class BoardForTesting {
    public Piece[][] board = new Piece[8][8];
    Board b = new Board(board);

    // Rooks
    Rook br1 = new Rook("R", "black", 0, 0, b);
    Rook br2 = new Rook("R", "black", 0, 7, b);
    Rook wr1 = new Rook("r", "white", 7, 0, b);
    Rook wr2 = new Rook("r", "white", 7, 7, b);

    // Knights
    Knight bk1 = new Knight("N", "black", 0, 1, b);
    Knight bk2 = new Knight("N", "black", 0, 6, b);
    Knight wk1 = new Knight("n", "white", 7, 1, b);
    Knight wk2 = new Knight("n", "white", 7, 6, b);

    // Bishops
    Bishop bb1 = new Bishop("B", "black", 0, 2, b);
    Bishop bb2 = new Bishop("B", "black", 0, 5, b);
    Bishop wb1 = new Bishop("b", "white", 7, 2, b);
    Bishop wb2 = new Bishop("b", "white", 7, 5, b);

    // Queens
    Queen bq = new Queen("Q", "black", 0, 3, b);
    Queen wq = new Queen("q", "white", 7, 3, b);

    // Kings
    King bk = new King("K", "black", 0, 4, b);
    King wk = new King("k", "white", 7, 4, b);

    // Black Pawns
    Pawn bp1 = new Pawn("P", "black", 1, 0, b);
    Pawn bp2 = new Pawn("P", "black", 1, 1, b);
    Pawn bp3 = new Pawn("P", "black", 1, 2, b);
    Pawn bp4 = new Pawn("P", "black", 1, 3, b);
    Pawn bp5 = new Pawn("P", "black", 1, 4, b);
    Pawn bp6 = new Pawn("P", "black", 1, 5, b);
    Pawn bp7 = new Pawn("P", "black", 1, 6, b);
    Pawn bp8 = new Pawn("P", "black", 1, 7, b);

    // White Pawns
    Pawn wp1 = new Pawn("p", "white", 6, 0, b);
    Pawn wp2 = new Pawn("p", "white", 6, 1, b);
    Pawn wp3 = new Pawn("p", "white", 6, 2, b);
    Pawn wp4 = new Pawn("p", "white", 6, 3, b);
    Pawn wp5 = new Pawn("p", "white", 6, 4, b);
    Pawn wp6 = new Pawn("p", "white", 6, 5, b);
    Pawn wp7 = new Pawn("p", "white", 6, 6, b);
    Pawn wp8 = new Pawn("p", "white", 6, 7, b);

    // Initialize board with pieces
    public BoardForTesting() {
        board[0][0] = br1;
        board[0][7] = br2;
        board[7][0] = wr1;
        board[7][7] = wr2;

        board[0][1] = bk1;
        board[0][6] = bk2;
        board[7][1] = wk1;
        board[7][6] = wk2;

        board[0][2] = bb1;
        board[0][5] = bb2;
        board[7][2] = wb1;
        board[7][5] = wb2;

        board[0][3] = bq;
        board[7][3] = wq;

        board[0][4] = bk;
        board[7][4] = wk;

        // Place black pawns
        board[1][0] = bp1;
        board[1][1] = bp2;
        board[1][2] = bp3;
        board[1][3] = bp4;
        board[1][4] = bp5;
        board[1][5] = bp6;
        board[1][6] = bp7;
        board[1][7] = bp8;

        // Place white pawns
        board[6][0] = wp1;
        board[6][1] = wp2;
        board[6][2] = wp3;
        board[6][3] = wp4;
        board[6][4] = wp5;
        board[6][5] = wp6;
        board[6][6] = wp7;
        board[6][7] = wp8;
    }

    public Board getBoard(){
        return this.b;
    }
}

