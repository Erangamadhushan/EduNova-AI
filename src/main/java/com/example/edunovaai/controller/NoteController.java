package com.example.edunovaai.controller;

import com.example.edunovaai.model.ChatRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.edunovaai.model.Note;
import com.example.edunovaai.service.NoteService;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:8081")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @GetMapping
    public List<Note> getNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        return noteService.chatWithNotes(request.getQuestion());
    }
}
