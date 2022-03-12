package uz.pdp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.exceptions.NotFoundException;
import uz.pdp.models.Auth;
import uz.pdp.services.auth.AuthService;

@Controller
@RequestMapping("auth/*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(value = "/login")
    private String loginPage() {
        return "auth/login";
    }

    @PostMapping(value = "login")
    private String login(@RequestParam String username, @RequestParam String password) {
        Auth auth = Auth.builder()
                .password(password)
                .username(username)
                .build();
        if (authService.isAdmin(auth)) {
            return "redirect:/book/list";
        }
        throw new NotFoundException("User not found");
    }

}
