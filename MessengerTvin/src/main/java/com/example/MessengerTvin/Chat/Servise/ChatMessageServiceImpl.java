package com.example.MessengerTvin.Chat.Servise;

import com.example.MessengerTvin.Chat.Entity.ChatMessege;
import com.example.MessengerTvin.Chat.Repository.ChatMessegeRepository;
import com.example.MessengerTvin.ChatRoom.Servise.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    @Autowired
    private ChatMessegeRepository chatMessegeRepository;

    @Autowired
    private ChatRoomService chatRoomService;

    @Override
    public ChatMessege saveChatMessege(ChatMessege chatMessege) {
        var chatId =chatRoomService.getChatRoomId(
                chatMessege.getSenderId(),
                chatMessege.getRecipientId(),
                true

        ).orElseThrow();
        chatMessege.setChatId(chatId);
        chatMessegeRepository.save(chatMessege);
        return chatMessege;
    }

    @Override
    public List<ChatMessege> findSaveChatMessage(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId,recipientId,false);
        return chatId.map(chatMessegeRepository::findByChatId).orElse(new ArrayList<>());
    }
}
