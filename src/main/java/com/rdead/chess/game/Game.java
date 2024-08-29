package com.rdead.chess.game;

import com.rdead.chess.chessLogic.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Game {
    private Player playerWhite;
    private Player playerBlack;
    private Board board;
    private int turn;

    public Game(Player playerWhite, Player playerBlack, Board board) {
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;
        this.board = board;
        this.turn = 0;
    }
}
