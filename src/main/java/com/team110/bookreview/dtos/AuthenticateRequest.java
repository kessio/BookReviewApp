package com.team110.bookreview.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticateRequest {
    @Email
    @NonNull
    private String email;
    @NonNull
    private String password;

}
