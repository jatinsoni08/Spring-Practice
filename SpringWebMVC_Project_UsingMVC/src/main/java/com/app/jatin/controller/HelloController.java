package com.app.jatin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/")
    public ModelAndView showMessage() {

        // Create object
        ModelAndView mav = new ModelAndView();

        // Sending data to JSP
        mav.addObject("msg", "Welcome To Spring MVC");

        // JSP page name
        mav.setViewName("home");

        return mav;
    }
}