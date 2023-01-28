package com.team110.bookreview;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private UUID bookId;
    private String title;
    private String author;
    private String description;
    private Date publicationDate;
    private String coverImage;
    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

}
