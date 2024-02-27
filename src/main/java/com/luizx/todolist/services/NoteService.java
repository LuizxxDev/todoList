package com.luizx.todolist.services;

import com.luizx.todolist.model.Note;
import com.luizx.todolist.repositories.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public void createNewNote(Note note){

        if (!repository.existsById(note.getCategory().getId())){
            throw new EntityNotFoundException("Categoria com o ID "
                    + note.getCategory().getId() + " não encontrada");
        }

        note.setDate(LocalDateTime.now());
        repository.save(note);
    }

    public List<Note> listAllNotes(){
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
