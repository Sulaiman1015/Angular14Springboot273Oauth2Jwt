package fr.sm.asojbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping( "/api")
public class LonginController {

    @PostMapping("/login")
    public String login(){
        return "login successfully";
    }
}
