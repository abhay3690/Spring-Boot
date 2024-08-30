package com.zosh.controller;

import com.zosh.model.Chat;
import com.zosh.model.User;
import com.zosh.request.CreateChatRequest;
import com.zosh.service.ChatService;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChatController{
    private final ChatService chatService;
    private final UserService userService;
    @PostMapping("/api/chats")
    public Chat createChat(@RequestHeader("Authorization") String jwt, @RequestBody CreateChatRequest req) throws Exception {
        User reqUser = userService.findUserByJwt(jwt);
        User user2 = userService.findUserById(req.getUserId());
        Chat chats = chatService.createChat(reqUser, user2);

        return chats;
    }
    @GetMapping("/api/chats")
    public List<Chat> findUsersChat(@RequestHeader("Authorization") String jwt){
        User reqUser = userService.findUserByJwt(jwt);
        List<Chat> chats = chatService.findUSerChat(reqUser.getId());
        return chats;
    }
}
