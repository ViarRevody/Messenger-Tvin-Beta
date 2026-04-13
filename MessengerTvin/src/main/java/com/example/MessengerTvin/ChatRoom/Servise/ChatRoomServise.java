package com.example.MessengerTvin.ChatRoom.Servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface ChatRoomServise {
    Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomInfoExist);

}

