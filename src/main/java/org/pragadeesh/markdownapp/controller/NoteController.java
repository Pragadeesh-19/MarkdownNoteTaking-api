package org.pragadeesh.markdownapp.controller;

import org.pragadeesh.markdownapp.model.Note;
import org.pragadeesh.markdownapp.model.NoteRequest;
import org.pragadeesh.markdownapp.model.NoteResponse;
import org.pragadeesh.markdownapp.repository.NoteRepository;
import org.pragadeesh.markdownapp.service.FIleStorageService;
import org.pragadeesh.markdownapp.service.GrammarCheckService;
import org.pragadeesh.markdownapp.service.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final MarkdownService markdownService;
    private final NoteRepository noteRepository;
    private final GrammarCheckService grammarCheckService;
    private final FIleStorageService fIleStorageService;

    @Autowired
    public NoteController(MarkdownService markdownService, NoteRepository noteRepository, GrammarCheckService grammarCheckService, FIleStorageService fIleStorageService) {
        this.markdownService = markdownService;
        this.noteRepository = noteRepository;
        this.grammarCheckService = grammarCheckService;
        this.fIleStorageService = fIleStorageService;
    }

    @PostMapping("/save")
    public ResponseEntity<NoteResponse> saveNote(@RequestBody NoteRequest noteRequest) {

        if(noteRequest.getTitle() == null || noteRequest.getMarkdownContent() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Note note = new Note();
        note.setTitle(noteRequest.getTitle());
        note.setMarkdownContent(noteRequest.getMarkdownContent());
        note.setHtmlContent(markdownService.convertToHtml(noteRequest.getMarkdownContent()));
        note.setGrammerCheckReport(null);

        Note savedNote = noteRepository.save(note);

        NoteResponse response = new NoteResponse();
        response.setId(savedNote.getId());
        response.setTitle(savedNote.getTitle());
        response.setMarkdownContent(savedNote.getMarkdownContent());
        response.setHtmlContent(savedNote.getHtmlContent());
        response.setGrammerCheckReport(savedNote.getGrammerCheckReport());

        return ResponseEntity.ok(response);

    }

    @GetMapping("/render/{id}")
    public String renderNote(@PathVariable Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        return noteOptional.map(Note::getHtmlContent).orElse("Note not found!");
    }

    @PostMapping("/check-grammer")
    public String checkGrammer(@RequestBody String text) {
        return grammarCheckService.checkGrammar(text);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file) {
        try {
            fIleStorageService.storeFile(file);
            return "File uploaded successfully: " + file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed: " + e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
