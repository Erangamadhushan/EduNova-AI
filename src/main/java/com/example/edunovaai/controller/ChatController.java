package com.example.edunovaai.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.edunovaai.model.Message;
import com.example.edunovaai.service.ChatService;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "http://localhost:8081")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Message sendMessage(@RequestParam(required = false) Long conversationId,
                               @RequestBody String question) {
        return chatService.sendMessage(conversationId, question);
    }

    @GetMapping("/conversations")
    public List<?> getConversations() {
        return chatService.getAllConversations();
    }

    @GetMapping("/{conversationId}")
    public List<Message> getMessages(@PathVariable Long conversationId) {
        return chatService.getMessages(conversationId);
    }
}