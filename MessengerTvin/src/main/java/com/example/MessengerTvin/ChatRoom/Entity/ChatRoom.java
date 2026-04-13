package com.example.MessengerTvin.ChatRoom.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chat_room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chatId;

    private String senderId;

    private String recipiendId;
}
