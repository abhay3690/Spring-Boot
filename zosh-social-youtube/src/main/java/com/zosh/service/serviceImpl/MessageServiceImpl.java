//package com.zosh.service.serviceImpl;
//
//import com.zosh.model.Chat;
//import com.zosh.model.Message;
//import com.zosh.model.User;
//import com.zosh.repository.MessageRepository;
//import com.zosh.service.ChatService;
//import com.zosh.service.MessageService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class MessageServiceImpl implements MessageService {
//    private final MessageRepository messageRepository;
//    private final ChatService chatService;
//    @Override
//    public Message createMessage(User user, Integer chatId, Message req) throws Exception {
//        Message message = new Message();
//        Chat chat = chatService.findChatById(chatId);
//        message.setChat(chat);
//        message.setContent(req.getContent());
//        message.setImage(req.getImage());
//        message.setUser(user);
//        message.setTimestamp(LocalDateTime.now());
//        return messageRepository.save(message);
//    }
//
//    @Override
//    public List<Message> findChatsMessage(Integer chatId) throws Exception {
//        Chat chat = chatService.findChatById(chatId);
//
//
//        return messageRepository.findByChatID(chatId);
//    }
//}
package com.zosh.service.serviceImpl;

import com.zosh.model.Chat;
import com.zosh.model.Message;
import com.zosh.model.User;
import com.zosh.repository.ChatRepository;
import com.zosh.repository.MessageRepository;
import com.zosh.service.ChatService;
import com.zosh.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final ChatRepository chatRepository;
    @Override
    public Message createMessage(User user, Integer chatId, Message req) throws Exception {
        Message message = new Message();
        Chat chat = chatService.findChatById(chatId);
        message.setChat(chat);
        message.setContent(req.getContent());
        message.setImage(req.getImage());
        message.setUser(user);
        message.setTimestamp(LocalDateTime.now());

        Message savedMessages = messageRepository.save(message);
        chat.getMessages().add(savedMessages);
        chatRepository.save(chat);
        return savedMessages;
    }

    @Override
    public List<Message> findChatsMessage(Integer chatId) throws Exception {
        Chat chat = chatService.findChatById(chatId);
        return messageRepository.findByChatId(chatId); // Corrected method name
    }
}
