package com.rdead.chess;

import com.rdead.chess.chessLogic.Board;
import com.rdead.chess.chessLogic.Pieces.King;
import com.rdead.chess.chessLogic.Pieces.Piece;
import com.rdead.chess.chessLogic.Pieces.Rook;
import com.rdead.chess.game.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class ChessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChessApplication.class, args);
    }
}
