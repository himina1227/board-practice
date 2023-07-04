package com.example.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/revert")
    public String revert() {
        return "revert test";
    }
}
