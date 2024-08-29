package com.rdead.chess.menu;

import com.rdead.chess.BoardForTesting;
import com.rdead.chess.BoardResponse;
import com.rdead.chess.GeneralMessage;
import com.rdead.chess.chessLogic.Board;
import com.rdead.chess.game.Game;
import com.rdead.chess.game.GameList;
import com.rdead.chess.game.Player;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {

    @MessageMapping("/menu")
    @SendTo("/topic/Response")
    public BoardResponse menu(GeneralMessage message){
        if(message.getCode()==1001){
            System.out.println("I am here");
            Game game = createNewGame(message.getUsername());
            GameList.addGame(game);
            String[][] board = game.getBoard().boardToSting();
            return new BoardResponse("Ok", 2001, board);
        }

        else{
            return new BoardResponse("Something went wrong", 9999, null);
        }
    }


    private Game createNewGame(String username){
        BoardForTesting board = new BoardForTesting();
        Board b = board.getBoard();
        Player p1 = new Player(username, "white");
        Player p2 = new Player(username, "black");
        return new Game(p1, p2, b);
    }

}
