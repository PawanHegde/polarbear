package com.pawanhegde.polarbear.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static org.hibernate.annotations.CascadeType.ALL;

@Entity
@Table(name="notes")
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @ManyToMany(fetch = EAGER)
    @Cascade(ALL)
    private Set<Tag> tags;
}
