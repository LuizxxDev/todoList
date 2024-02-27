package com.luizx.todolist.controller;

import com.luizx.todolist.model.Note;
import com.luizx.todolist.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Note> createNewNote(@RequestBody Note note){
        service.createNewNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Note>> listAllNotes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable Long id){
        service.deleteNoteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity deleteAllNotes(){
        service.deleteAllNotes();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
