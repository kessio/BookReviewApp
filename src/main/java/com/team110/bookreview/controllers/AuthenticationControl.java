package com.team110.bookreview.controllers;


import com.team110.bookreview.apiresponse.APIResponse;
import com.team110.bookreview.apiresponse.Response;
import com.team110.bookreview.configurations.security.CustomUserDetailService;
import com.team110.bookreview.configurations.security.JwtUtil;
import com.team110.bookreview.dtos.AuthResponse;
import com.team110.bookreview.dtos.LoginRequestDto;
import com.team110.bookreview.entities.User;
import com.team110.bookreview.exceptions.BadCredentialException;
import com.team110.bookreview.exceptions.UserNotFoundException;
import com.team110.bookreview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;


@RestController("/auth")
@RequiredArgsConstructor
public class AuthenticationControl {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    private final Response responseEntity;
    private final UserRepository userRepository;


    @PostMapping("/login")
    public APIResponse<AuthResponse> logInUser (@Validated @RequestBody LoginRequestDto loginRequestDto){
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getEmail());
        String token = jwtUtil.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse(token);
        return responseEntity.success(authResponse);
    }


}
