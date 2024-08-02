package com.rdead.chess.user;

import com.rdead.chess.signup.SignupMessage;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserMapper {

    public User signupMessageToUser(SignupMessage message){
        User user = new User();
        user.setUsername(message.getUsername());
        user.setPassword(message.getPassword());
        user.setEmail(message.getEmail());
        user.setSignupDate(LocalDateTime.now());
        return user;
    }
}
