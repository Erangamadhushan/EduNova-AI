package com.example.edunovaai.model.DTO;

public class ChatResponse {
    private Long conversationId;
    private String answer;

    public ChatResponse(Long conversationId, String answer) {
        this.conversationId = conversationId;
        this.answer = answer;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public String getAnswer() {
        return answer;
    }
}
