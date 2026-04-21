package com.example.MessengerTvin.Chat.Controller;


import com.example.MessengerTvin.Chat.Entity.ChatMessege;
import com.example.MessengerTvin.Chat.Entity.ChatNotification;
import com.example.MessengerTvin.Chat.Servise.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ChatMessageController {
    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessege chatMessege){
        ChatMessege savedMessage =chatMessageService.saveChatMessege(chatMessege);
        simpMessagingTemplate.convertAndSendToUser(chatMessege.getRecipientId(),"/queue/messages",
                new ChatNotification(
                        savedMessage.getId(),
                        savedMessage.getSenderId(),
                        savedMessage.getRecipientId(),
                        savedMessage.getContent()
                ));
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessege>> findChatMessages(@PathVariable String senderId,
                                                              @PathVariable String recipientId){
        return ResponseEntity.ok(chatMessageService.findSaveChatMessage(senderId,recipientId));
    }
}
