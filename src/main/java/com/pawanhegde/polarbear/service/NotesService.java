package com.pawanhegde.polarbear.service;

import com.pawanhegde.polarbear.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class NotesService {
    private SessionFactory sessionFactory;

    public List<Note> getNotes() {
        Session session = getSession();

        session.beginTransaction();
        return session.createQuery("from note", Note.class).list();
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
        session.persist(note);
        session.getTransaction().commit();

        session.close();
    }

    private Session getSession () {
        if(sessionFactory == null) {
            Properties properties = new Properties();
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/test");
//            properties.setProperty("hibernate.id.new_generator_mappings","false");
//            properties.setProperty("hibernate.hbm2ddl.auto","create");
            properties.setProperty("hibernate.connection.username", "pawan");
            properties.setProperty("hibernate.connection.password", "password");

            Configuration configuration = new Configuration().setProperties(properties);
            configuration.addAnnotatedClass(Note.class);

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory.openSession();
    }
}
