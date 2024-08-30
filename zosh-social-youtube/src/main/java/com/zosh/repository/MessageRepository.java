//package com.zosh.repository;
//
//import com.zosh.model.Message;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface MessageRepository extends JpaRepository<Message,Integer> {
//    public List<Message> findByChatID(Integer chatId);
//}
package com.zosh.repository;

import com.zosh.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    // Correct method name to match the field name in the Chat entity
    List<Message> findByChatId(Integer chatId);
}
