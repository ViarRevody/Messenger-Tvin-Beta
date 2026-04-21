package com.example.MessengerTvin.Chat.Repository;

import com.example.MessengerTvin.Chat.Entity.ChatMessege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChatMessegeRepository extends JpaRepository<ChatMessege, Long> {
     List<ChatMessege> findByChatId(String chatId);
}