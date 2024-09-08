package com.rdead.chess.menu;

import com.rdead.chess.BoardResponse;
import com.rdead.chess.GeneralMessage;
import com.rdead.chess.game.Game;
import com.rdead.chess.game.GameList;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {

    @MessageMapping("/menu")
    @SendTo("/topic/Response")
    public BoardResponse menu(GeneralMessage message){
        if(message.getCode()==1001){
            Game game = new Game(message.getUsername(), "computer", 1);
            int id = GameList.addGame(game);
            String[][] board = game.getBoard().boardToSting();
            return new BoardResponse("Ok", 2001, board, id);
        }

        else{
            return new BoardResponse("Something went wrong", 9999, null, -1);
        }
    }
}
