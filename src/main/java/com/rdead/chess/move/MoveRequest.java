package com.rdead.chess.move;

import lombok.Data;

@Data
public class MoveRequest {
    private Coordinates from;
    private Coordinates to;
    private String username;
    private int gameId;
}
