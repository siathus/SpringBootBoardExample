package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "freeboard")
public class Freeboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "freeId")
    private Long freeid;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;
}
