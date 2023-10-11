package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("userMassage", "Nieprawidłowy email lub hasło");
        return "login";
    }
}
