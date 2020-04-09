package io.ao9.crmspringcrud.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(Model theModel) {
        theModel.addAttribute("theDate", new Date());
        return "home";
    }
}