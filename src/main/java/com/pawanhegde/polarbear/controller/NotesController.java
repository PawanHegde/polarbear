package com.pawanhegde.polarbear.controller;

import com.pawanhegde.polarbear.model.Note;
import com.pawanhegde.polarbear.model.Tag;
import com.pawanhegde.polarbear.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping("/notes")
    private List<Note> getNotes() {
        return notesService.getNotes();
    }

    @GetMapping("/notes/{id}")
    private Note getNote(@PathVariable Integer id) {
        return notesService.getNote(id);
    }

    @PutMapping("/notes")
    private void putNote(@RequestBody Note note) {
        notesService.putNote(note);
    }

    @GetMapping("/tags")
    private List<Tag> getTags() {
        return notesService.getTags();
    }

    @PostMapping("/notes/{id}/{tag}")
    private void addTagToNote(@PathVariable("id") Integer id, @PathVariable("tag") String tagText) {
        Tag tag = new Tag();
        tag.setName(tagText);
        notesService.addTagToNote(id, tag);
    }
}
