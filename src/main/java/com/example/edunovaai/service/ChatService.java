package com.example.edunovaai.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.edunovaai.model.*;
import com.example.edunovaai.repository.*;

@Service
public class ChatService {

    private final ConversationRepository conversationRepo;
    private final MessageRepository messageRepo;
    private final AIService aiService;

    public ChatService(ConversationRepository conversationRepo,
                       MessageRepository messageRepo,
                       AIService aiService) {
        this.conversationRepo = conversationRepo;
        this.messageRepo = messageRepo;
        this.aiService = aiService;
    }

    public Message sendMessage(Long conversationId, String question) {

        Conversation conversation;

        if (conversationId == null) {
            conversation = new Conversation();
            conversation.setTitle(question.substring(0, Math.min(30, question.length())));
            conversation = conversationRepo.save(conversation);
        } else {
            conversation = conversationRepo.findById(conversationId).orElseThrow();
        }

        // Save user message
        Message userMsg = new Message();
        userMsg.setRole("user");
        userMsg.setContent(question);
        userMsg.setConversation(conversation);
        messageRepo.save(userMsg);

        // Generate AI response
        String answer = aiService.answerQuestion(question, "");

        // Save AI message
        Message aiMsg = new Message();
        aiMsg.setRole("assistant");
        aiMsg.setContent(answer);
        aiMsg.setConversation(conversation);
        messageRepo.save(aiMsg);

        return aiMsg;
    }

    public List<Conversation> getAllConversations() {
        return conversationRepo.findAll();
    }

    public List<Message> getMessages(Long conversationId) {
        return messageRepo.findAll()
                .stream()
                .filter(m -> m.getConversation().getId().equals(conversationId))
                .toList();
    }
}