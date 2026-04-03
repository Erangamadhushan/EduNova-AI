package com.example.edunovaai.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.edunovaai.model.Note;
import com.example.edunovaai.repository.NoteRepository;
import com.example.edunovaai.service.AIService;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final AIService aiService;

    public NoteService(NoteRepository noteRepository, AIService aiService) {
        this.noteRepository = noteRepository;
        this.aiService = aiService;
    }

    public Note saveNote(Note note) {
        String summary = aiService.generateSummary(note.getContent());
        note.setSummary(summary);
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public String chatWithNotes(String question) {
        List<Note> notes = noteRepository.findAll();

        StringBuilder combinedContent = new StringBuilder();

        for (Note note : notes) {
            combinedContent.append(note.getContent()).append("\n");
        }

        return aiService.answerQuestion(question, combinedContent.toString());
    }
}
