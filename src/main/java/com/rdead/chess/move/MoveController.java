package com.rdead.chess.move;

import com.rdead.chess.BoardForTesting;
import com.rdead.chess.Response;
import com.rdead.chess.chessLogic.Board;
import com.rdead.chess.chessLogic.MoveHandler;
import com.rdead.chess.chessLogic.Pieces.Piece;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class MoveController {

    @MessageMapping("/move")
    @SendTo("/topic/Response")
    public Response handleMove(MoveRequest moveRequest){
        return MoveHandler.checkMove(moveRequest) ;
    }
}
