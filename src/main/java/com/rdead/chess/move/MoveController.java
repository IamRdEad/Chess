package com.rdead.chess.move;

import com.rdead.chess.Response;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MoveController {

    @MessageMapping("/move")
    @SendTo("/topic/moveResponse")
    public Response handleMove(MoveRequest moveRequest){
        int fromRow = moveRequest.getFrom().getRow();
        int fromCol = moveRequest.getFrom().getCol();
        int toRow = moveRequest.getTo().getRow();
        int toCol = moveRequest.getTo().getCol();

        System.out.println("Received move from: (" + fromRow + ", " + fromCol + ") to (" + toRow + ", " + toCol + ")");

        return null;
    }
}
