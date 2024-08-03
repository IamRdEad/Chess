package com.rdead.chess.signup;

import com.rdead.chess.Response;
import com.rdead.chess.user.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SignupController {

    private final UserService service;
    private final UserMapper mapper;

    public SignupController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @MessageMapping("/signup")
    @SendTo("/topic/Response")
    public Response handleSignUp(SignupMessage message) throws Exception{
        User user = mapper.signupMessageToUser(message);
        try {
            service.saveUser(user);
            return new Response("User " + user.getUsername() + " registered successfully!",100);
        }catch (DataIntegrityViolationException exception){
            return new Response("Username or email already exists. Please try a different one.",101);
        }
    }
}
