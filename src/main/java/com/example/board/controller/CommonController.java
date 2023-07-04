package com.example.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    // merge test
    @RequestMapping("/1")
    public String hello() {
        return "helloTest11";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/tes2t3")
    public String test3() {
        return "test3";
    }
}