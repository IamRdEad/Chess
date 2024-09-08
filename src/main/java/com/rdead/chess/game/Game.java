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

    public Game(String playerWhite, String playerBlack, int code) {
        this.playerWhite = new Player(playerWhite, "white");
        this.playerBlack = new Player(playerBlack, "black");
        this.board = new Board(code);
        this.turn = 0;
    }
}
