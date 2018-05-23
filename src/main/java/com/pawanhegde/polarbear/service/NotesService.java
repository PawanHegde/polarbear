package com.pawanhegde.polarbear.service;

import com.pawanhegde.polarbear.model.Note;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class NotesService {
    private List<Note> notes = new LinkedList<>();

    public List<Note> getNotes() {
        return notes;
    }

    public Note getNote(Integer id) {
        return notes.stream().filter(note -> note.id.equals(id)).findAny().get();
    }

    public void putNote(Note note) {
        notes.add(note);
    }
}
