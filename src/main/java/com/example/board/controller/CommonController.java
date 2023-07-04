package com.example.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    // merge test
    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}