package pl.coderslab.charity.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping
    public String profilePage(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);

        return "profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfileForm(@RequestParam("email") String email, Principal principal, RedirectAttributes redirectAttributes) {
        User userByEmail = userRepository.findByEmail(email);

        if (userByEmail != null) {
            redirectAttributes.addFlashAttribute("errorMsg", "Podany adres e-mail jest już w użyciu.");
            return "redirect:/profile";
        }
        User user = userRepository.findByEmail(principal.getName());

        if (user == null) {
            redirectAttributes.addFlashAttribute("errorMsg", "Nie znaleziono aktualnego użytkownika.");
            return "redirect:/profile";
        }
        user.setEmail(email);
        userRepository.save(user);

        redirectAttributes.addFlashAttribute("infoMsg", "Twój adres e-mail został zmieniony. Proszę zalogować się ponownie.");

        return "redirect:/login";
    }




}
