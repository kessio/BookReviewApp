package com.team110.bookreview.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    // checking controller is working or not
    @GetMapping("/chiku")
    public String add(){
        return "chiku";
    }
}
