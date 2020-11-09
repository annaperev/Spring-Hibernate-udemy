package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")// have to match up with loginPage from DemoSecurityConfig
    public String showMyLoginPage(){

        return "fancy-login";
    }
}
