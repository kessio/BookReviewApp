package com.team110.bookreview;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private UUID reviewId;

    @ManyToOne
    private Book book;

    private String review;

    private double rating;

}
