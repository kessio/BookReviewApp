package com.team110.bookreview;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "member")//user_tbl
public class Member {
    @Id
    private UUID memberId;
    private String name;
    @OneToMany(mappedBy = "member")
    private List<Review> reviews;

}
