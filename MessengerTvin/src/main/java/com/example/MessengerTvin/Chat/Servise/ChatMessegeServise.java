package com.example.MessengerTvin.Chat.Servise;

import com.example.MessengerTvin.Chat.Entity.ChatMessege;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatMessegeServise {
    ChatMessege saveChatMessege(ChatMessege chatMessege);

    List<ChatMessege> findSaveChatMessege(String senderId, String recipientId);

}
