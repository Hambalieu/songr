package com.Hambalieu.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String helloMethod(){
        return "hello.html";
    }

    @GetMapping("/capitalize/{words}")
    public String getCapitalize(@PathVariable String words, Model m) {
        m.addAttribute("words", setCapitalize(words));
        return "capitalize.html";
    }

    public static String setCapitalize(String words) {
        return words.toUpperCase();
    }

}
