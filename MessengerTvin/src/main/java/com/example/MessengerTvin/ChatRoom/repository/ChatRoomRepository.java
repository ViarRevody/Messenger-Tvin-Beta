package com.example.MessengerTvin.ChatRoom.repository;

import com.example.MessengerTvin.ChatRoom.Entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findBySenderIdAndRecipient(String senderId, String recipientId);

}