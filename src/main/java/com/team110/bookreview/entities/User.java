package com.team110.bookreview.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    private UUID userId;
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Review> reviews;

}
