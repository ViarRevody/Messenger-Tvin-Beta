package com.example.MessengerTvin.Chat.Servise;

import com.example.MessengerTvin.Chat.Entity.ChatMessege;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatMessageService {
    ChatMessege saveChatMessege(ChatMessege chatMessege);

    List<ChatMessege> findSaveChatMessage(String senderId, String recipientId);

}
