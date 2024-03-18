package org.carlos.flycommerce.Controllers.Chat;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.MongoDB.UserMongo;
import org.carlos.flycommerce.Services.Chat.UserChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserChatController {
    private final UserChatService userChatService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public UserMongo addUser(@Payload  UserMongo user) {
        System.out.println("User added: " + user.getName());
         userChatService.saveUser(user);
         return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public UserMongo disconnectUser(UserMongo user) {
        userChatService.disconnect(user);
        return user;
    }

    @GetMapping("/api/chat/users")
    public ResponseEntity<List<UserMongo>> findConnectedUsers() {
        return ResponseEntity.ok(userChatService.getOnlineUsers());
    }
}
