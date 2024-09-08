package com.rdead.chess;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse extends Response{
    private String[][] board;
    private int gameId;

    public BoardResponse(String content, int code, String[][] board, int gameId) {
        super(content, code);
        this.board = board;
        this.gameId = gameId;
    }
}


