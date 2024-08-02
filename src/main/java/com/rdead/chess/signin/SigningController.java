package com.rdead.chess.signin;

import com.rdead.chess.Response;
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
        System.out.println("trying to connect with: " + message.getUsername());
        if (repository.isCorrect(message.getUsername(), message.getPassword())) {
            return new Response("Welcome back " + message.getUsername());
        }
        return new Response("Username or Password doesn't match");
    }
}
