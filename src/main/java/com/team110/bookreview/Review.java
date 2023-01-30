package com.team110.bookreview;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private UUID reviewId;

    @ManyToOne
    private Book book;

    private String review;

    private double rating;

    @ManyToOne
    private Member member;

}
