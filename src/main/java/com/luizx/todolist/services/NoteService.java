package com.luizx.todolist.services;

import com.luizx.todolist.model.Note;
import com.luizx.todolist.repositories.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public void insertNewNote(Note note){
        repository.save(note);
    }

    public List<Note> findAllNotes(){
        return repository.findAll(Sort.by(Sort.Order.asc("title")));
    }

    public Note findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Nota não encontrada"));
    }

    public void deleteNoteById(Long id){
        repository.deleteById(id);
    }

    public void deleteAllNotes(){
        repository.deleteAll();
    }



}
