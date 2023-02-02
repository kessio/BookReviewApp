package com.team110.bookreview.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    @Email
    @NonNull
    private String email;
    @NonNull
    private String password;

}
