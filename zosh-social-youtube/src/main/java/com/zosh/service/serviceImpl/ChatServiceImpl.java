package com.zosh.service.serviceImpl;

import com.zosh.model.Chat;
import com.zosh.model.User;
import com.zosh.repository.ChatRepository;
import com.zosh.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;
    @Override
    public Chat createChat(User reqUser, User user2) {
        Chat isExist = chatRepository.findChatByUsersId(user2,reqUser);
        if (isExist != null){
            return isExist;
        }
        Chat chat = new Chat();
        chat.getUsers().add(user2);
        chat.getUsers().add(reqUser);
        chat.setTimestamp(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    @Override
    public Chat findChatById(Integer chatId) throws Exception {
        Optional<Chat> opt= chatRepository.findById(chatId);
        if (opt.isEmpty()){
            throw new Exception("Chat nit found with this id " + chatId);
        }
        return opt.get();
    }

    @Override
    public List<Chat> findUSerChat(Integer userId) {
        return chatRepository.findByUsersId(userId);
    }
}
