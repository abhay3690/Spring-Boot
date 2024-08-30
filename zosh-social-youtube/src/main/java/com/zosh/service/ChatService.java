package com.zosh.service;

import com.zosh.model.Chat;
import com.zosh.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService {
    public Chat createChat(User reqUser, User user2);
    public Chat findChatById(Integer chatId) throws Exception;
    public List<Chat> findUSerChat(Integer userId);
}
