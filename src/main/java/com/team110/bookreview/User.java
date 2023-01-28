package com.team110.bookreview;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
    @Id
    private UUID user_id;
    private String name;
}
