package com.kitapcidayi.kitapcidayi.controller;

import com.kitapcidayi.kitapcidayi.service.BooKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private BooKService bookService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String listFreeBooks(Model model) {
        model.addAttribute("books", bookService.listFreeBooks());
        return "index";
    }

}
