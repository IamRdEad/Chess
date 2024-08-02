package com.rdead.chess.signup;

import com.rdead.chess.user.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class SignupController {

    private final UserService service;
    private final UserRepository repository;

    public SignupController(UserService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @MessageMapping("/signup")
    @SendTo("/topic/signupResponse")
    public SignupResponse handleSignUp(SignupMessage message) throws Exception{
        User user = service.saveUser(message);
        repository.save(user);
        return new SignupResponse("User "+ message.getUsername() + "registered successfully!");
    }
}
