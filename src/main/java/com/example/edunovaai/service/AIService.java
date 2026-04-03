package com.example.edunovaai.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;

@Service
public class AIService {

    private final String API_KEY = "";

    public String generateSummary(String content) {
        try {
            String url = "https://api.openai.com/v1/chat/completions";

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + API_KEY);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> body = new HashMap<>();
            body.put("model", "gpt-4o-mini");

            List<Map<String, String>> messages = new ArrayList<>();

            Map<String, String> system = new HashMap<>();
            system.put("role", "system");
            system.put("content", "Summarize the following note clearly:");

            Map<String, String> user = new HashMap<>();
            user.put("role", "user");
            user.put("content", content);

            messages.add(system);
            messages.add(user);

            body.put("messages", messages);

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(body, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(url, request, Map.class);

            // Extract summary
            List choices = (List) response.getBody().get("choices");
            Map choice = (Map) choices.get(0);
            Map message = (Map) choice.get("message");

            return message.get("content").toString();
        } catch (Exception e) {
            return "AI service temporarily unavailable. Showing fallback summary.";
        }
    }

    public String answerQuestion(String question, String notesContent) {

        return "Mock Answer:\nBased on your notes, the answer to '"
                + question + "' is related to: \n"
                + notesContent.substring(0, Math.min(100, notesContent.length())) + "...";
    }
}