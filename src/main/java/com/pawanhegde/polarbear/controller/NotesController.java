package com.pawanhegde.polarbear.controller;

import com.pawanhegde.polarbear.model.Note;
import com.pawanhegde.polarbear.model.Tag;
import com.pawanhegde.polarbear.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping("/notes")
    List<Note> getNotes() {
        return notesService.getNotes();
    }

    @GetMapping("/notes/{id}")
    Note getNote(@PathVariable Integer id) {
        return notesService.getNote(id);
    }

    @PutMapping("/notes")
    void putNote(@RequestBody Note note) {
        Tag tag = new Tag();
        tag.setName("Random#ness");
        note.setTags(Set.of(tag));
        notesService.putNote(note);
    }
}
