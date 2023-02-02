package com.team110.bookreview.controllers;


import com.team110.bookreview.apiresponse.APIResponse;
import com.team110.bookreview.apiresponse.Response;
import com.team110.bookreview.dtos.AuthResponse;
import com.team110.bookreview.dtos.LoginRequestDto;
import com.team110.bookreview.dtos.UserDto;
import com.team110.bookreview.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookreview/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final Response apiResponse;


    @PostMapping("/register")
    public APIResponse<AuthResponse> registerNewUser (@Validated @RequestBody UserDto userDto){
        return apiResponse.success(userService.registerNewUser(userDto));
    }
}