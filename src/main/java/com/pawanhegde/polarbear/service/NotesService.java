package com.pawanhegde.polarbear.service;

import com.pawanhegde.polarbear.model.Note;
import com.pawanhegde.polarbear.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private SessionFactory sessionFactory;

    private Session getSession () {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Note.class);
            configuration.addAnnotatedClass(Tag.class);

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory.openSession();
    }

    public List<Note> getNotes() {
        Session session = getSession();

        session.beginTransaction();
        List<Note> notes = session.createQuery("from Note", Note.class).list();
        session.close();

        return notes;
    }

    public Note getNote(Integer id) {
        Session session = getSession();

        session.beginTransaction();
        Note note = session.get(Note.class, id);
        session.close();

        return note;
    }

    public void putNote(Note note) {
        Session session = getSession();

        session.beginTransaction();
        session.saveOrUpdate(note);
        session.getTransaction().commit();

        session.close();
    }

    public void addTagToNote(Integer id, Tag tag) {
        Session session = getSession();

        session.beginTransaction();
        Note note = session.get(Note.class, id);
        note.getTags().add(tag);
        session.saveOrUpdate(note);

        session.getTransaction().commit();

        session.close();
    }

    public List<Tag> getTags() {
        Session session = getSession();

        session.beginTransaction();
        List<Tag> tags = session.createQuery("from Tag", Tag.class).getResultList();
        session.close();

        return tags;
    }
}
