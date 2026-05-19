package com.app.jatin.ourcontroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class OurController {

    @GetMapping("/home")
    public String showPage(Model model) {
        return "mypage";
    }
}