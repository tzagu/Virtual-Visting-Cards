package com.example.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PersonController {

    @GetMapping("/idk")
    public String list(){
        return "person";
    }
}
