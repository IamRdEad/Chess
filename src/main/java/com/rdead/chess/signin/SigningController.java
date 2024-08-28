package com.rdead.chess.signin;

import com.rdead.chess.BoardForTesting;
import com.rdead.chess.Response;
import com.rdead.chess.chessLogic.Board;
import com.rdead.chess.game.Game;
import com.rdead.chess.game.GameList;
import com.rdead.chess.game.Player;
import com.rdead.chess.user.UserRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SigningController {

    private final UserRepository repository;

    public SigningController(UserRepository repository) {
        this.repository = repository;
    }

    @MessageMapping("/signin")
    @SendTo("/topic/Response")
    public Response handleSigning(SigningMessage message) {
        if (repository.isCorrect(message.getUsername(), message.getPassword())) {
            Game game = createNewGame(message.getUsername()); //only now for testing will be changed
            GameList.addGame(game);
            return new Response("Welcome back " + message.getUsername(),200);
        }
        return new Response("Username or Password doesn't match",201);
    }

    private Game createNewGame(String username){
        BoardForTesting board = new BoardForTesting();
        Board b = board.getBoard();
        Player p1 = new Player(username, "white");
        Player p2 = new Player(username, "black");
        return new Game(p1, p2, b);
    }
}
