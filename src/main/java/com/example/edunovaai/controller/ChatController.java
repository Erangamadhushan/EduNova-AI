package com.example.edunovaai.controller;

import com.example.edunovaai.model.DTO.ChatResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.edunovaai.model.Message;
import com.example.edunovaai.model.DTO.ChatRequest;
import com.example.edunovaai.service.ChatService;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "http://localhost:8081")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/conversations")
    public ChatResponse startConversation(@RequestBody ChatRequest request) {
        return chatService.startConversation(request.getQuestion());
    }

    // ✅ Send message to existing conversation
    @PostMapping("/{conversationId}/messages")
    public ChatResponse sendMessage(
            @PathVariable Long conversationId,
            @RequestBody ChatRequest request
    ) {
        return chatService.sendMessage(conversationId, request.getQuestion());
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