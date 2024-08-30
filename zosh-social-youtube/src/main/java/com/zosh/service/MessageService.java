package com.zosh.service;

import com.zosh.model.Chat;
import com.zosh.model.Message;
import com.zosh.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    public Message createMessage(User user, Integer chatId, Message req) throws Exception;
    public List<Message> findChatsMessage(Integer chatId) throws Exception;
}
