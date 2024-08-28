package com.rdead.chess.move;

import com.rdead.chess.BoardResponse;
import com.rdead.chess.Response;
import com.rdead.chess.chessLogic.MoveHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MoveController {

    @MessageMapping("/move")
    @SendTo("/topic/Response")
    public BoardResponse handleMove(MoveRequest moveRequest){
        return MoveHandler.checkMove(moveRequest) ;
    }
}
