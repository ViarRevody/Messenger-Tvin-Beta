package com.example.MessengerTvin.ChatRoom.Servise;

import com.example.MessengerTvin.ChatRoom.Entity.ChatRoom;
import com.example.MessengerTvin.ChatRoom.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ChatRoomServiseImpl implements ChatRoomServise{

    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Override
    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomInfoExist) {
        return chatRoomRepository.findBySenderIdAndRecipiend(senderId,recipientId)
                .map(ChatRoom::getChatId)
                .or(()->{
                    if(createNewRoomInfoExist){
                        var chatId = createChatId(senderId,recipientId);
                    }
                    return Optional.empty();
                });
    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s",senderId,recipientId);
        ChatRoom sendRecipient = ChatRoom.builder()
                .chatId(chatId)
                .recipiendId(recipientId)
                .senderId(senderId)
                .build();
        ChatRoom recipientSender =ChatRoom.builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipiendId(senderId)
                .build();
        chatRoomRepository.save(sendRecipient);
        chatRoomRepository.save(recipientSender);
        return chatId;
    }
}
