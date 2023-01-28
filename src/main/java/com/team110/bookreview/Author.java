package com.team110.bookreview;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "author")
public class Author {
    @Id
    private UUID author_id;
    private String name;
    private String bio;
}
