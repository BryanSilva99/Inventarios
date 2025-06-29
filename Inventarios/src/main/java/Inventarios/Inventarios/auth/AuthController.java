package Inventarios.Inventarios.auth;

import Inventarios.Inventarios.entities.Usuario;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Usuario usuario) {
        authService.register(usuario);
        return "redirect:/auth/login"; // redirige al login
    }

    @GetMapping(value = "login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // crea un home.html para mostrar después del login
    }

}
