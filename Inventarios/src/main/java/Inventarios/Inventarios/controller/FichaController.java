package Inventarios.Inventarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FichaController {

    @GetMapping("/ficha")
    private String crearFicha(){
        return "ficha.html";
    }
}
