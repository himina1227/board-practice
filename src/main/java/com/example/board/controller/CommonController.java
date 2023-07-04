package com.example.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    // merge test
    @RequestMapping("/")
    public String hello2() {
        return "hello2";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/test3")
    public String test3() {
        return "test3";
    }
}