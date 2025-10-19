package com.example.ShopAnime.controller;

import com.example.ShopAnime.DTO.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/send") // client gửi tới /app/send
    @SendTo("/topic/messages") // tất cả client đang subscribe /topic/messages sẽ nhận được
    public ChatMessage send(ChatMessage message) {
        System.out.println("Nhận từ " + message.getFrom() + ": " + message.getContent());
        return message; // gửi lại cho tất cả client
    }
}
