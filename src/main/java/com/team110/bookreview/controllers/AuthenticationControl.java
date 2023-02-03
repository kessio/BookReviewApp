package com.team110.bookreview.controllers;


import com.team110.bookreview.apiresponse.APIResponse;
import com.team110.bookreview.apiresponse.ApiDataResponse;
import com.team110.bookreview.apiresponse.ApiResponseUtil;
import com.team110.bookreview.apiresponse.Response;
import com.team110.bookreview.configurations.security.CustomUserDetailService;
import com.team110.bookreview.configurations.security.LoginService;
import com.team110.bookreview.dtos.AuthResponse;
import com.team110.bookreview.dtos.AuthenticateRequest;
import com.team110.bookreview.dtos.LoginRequestDto;
import com.team110.bookreview.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    private final Response apiResponse;



//    @PostMapping("/login")
//    public ResponseEntity<ApiDataResponse<AuthResponse>> login(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
//        String token = loginService.authenticate(authenticateRequest);
//        AuthResponse authResponse = new AuthResponse(token);
//        System.out.println(token);
//        return ApiResponseUtil.response(HttpStatus.OK, authResponse, "SIGN_IN_SUCCESSFULLY");
//    }

    @PostMapping("/login")
    public APIResponse<AuthResponse> login (@Validated @RequestBody AuthenticateRequest authenticateRequest) throws Exception {
        String token = loginService.authenticate(authenticateRequest);
        AuthResponse authResponse = new AuthResponse(token);
        System.out.println(token);
        return apiResponse.success(authResponse);
    }
}
