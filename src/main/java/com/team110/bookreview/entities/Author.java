package com.team110.bookreview.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
@Data
@Entity
@Table(name = "author_tbl")
public class Author {
    @Id
    private UUID author_id;
    private String name;
    private String bio;
}
