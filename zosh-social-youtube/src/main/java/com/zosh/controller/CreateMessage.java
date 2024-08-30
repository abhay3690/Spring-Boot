package com.zosh.controller;

import com.zosh.model.Message;
import com.zosh.model.User;
import com.zosh.service.MessageService;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CreateMessage {
    private final MessageService messageService;
    private final UserService userService;
    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@RequestHeader("Authorization") String jwt, @PathVariable Integer chatId, @RequestBody Message req) throws Exception {
        User user = userService.findUserByJwt(jwt);
        Message message =messageService.createMessage(user,chatId, req);
        return message;
    }
    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> findChatsMessages(@RequestHeader("Authorization") String jwt, @PathVariable Integer chatId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        List<Message> messages =messageService.findChatsMessage(chatId);
        return messages;
    }
}
