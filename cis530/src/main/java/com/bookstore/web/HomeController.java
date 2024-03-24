/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Gold, P. (2021). Bellevue University 
 */ 
// Credited Professor Gold due to following along his classroom instructions.

package com.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method=RequestMethod.GET)
    public String showHome(Model model) {
        return "index";
    }

    @RequestMapping(method=RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model) {
        return "about";
    }

    @RequestMapping(method=RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model) {
        return "contact";
    }
}



