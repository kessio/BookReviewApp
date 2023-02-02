package com.team110.bookreview.controllers;


import com.team110.bookreview.apiresponse.ApiDataResponse;
import com.team110.bookreview.apiresponse.ApiResponseUtil;
import com.team110.bookreview.configurations.security.CustomUserDetailService;
import com.team110.bookreview.configurations.security.JwtUtil;
import com.team110.bookreview.configurations.security.LoginService;
import com.team110.bookreview.dtos.AuthResponse;
import com.team110.bookreview.dtos.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class AuthenticationControl {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService userDetailsService;
    private final LoginService loginService;



    @PostMapping("/login")
    public ResponseEntity<ApiDataResponse<AuthResponse>> login(@Validated @RequestBody LoginRequestDto loginRequestDto) throws Exception {
        String token = loginService.authenticate(loginRequestDto);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getEmail());
        AuthResponse authResponse = new AuthResponse(token);
        return ApiResponseUtil.response(HttpStatus.OK, authResponse, "SIGN_IN_SUCCESSFULLY");
    }
}
