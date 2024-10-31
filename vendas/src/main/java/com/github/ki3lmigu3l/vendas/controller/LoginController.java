package com.github.ki3lmigu3l.vendas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String paginaLogin () {
        return "/login";
    }
}
