package com.pawanhegde.polarbear.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String name;
}
