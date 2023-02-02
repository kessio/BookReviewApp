package com.team110.bookreview.dtos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;
@Data
public class UserDto {
    @Size(min = 1, message = "Name must be more than one letter")
    private String name;
    @Email(message = "Provide a valid email")
    private String email;
    private String password;
}
