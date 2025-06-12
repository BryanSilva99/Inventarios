package Inventarios.Inventarios.controller;

import Inventarios.Inventarios.entities.Bien;
import Inventarios.Inventarios.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BienController {

    @Autowired
    private BienService bienService;

    @GetMapping("/crearBien")
    public String crearBien(Model model){
        model.addAttribute("bien",new Bien());
        return "crearBien";
    }

    @PostMapping("/registrarBien")
    public String registrarBien(@ModelAttribute Bien bien){
        bienService.agregarBien(bien);
        return  "redirect:/listaBienes";
    }

    @GetMapping("/listaBienes")
    public String listaBienes(Model model){
        List<Bien> listaBienes= bienService.listarBienes();
        model.addAttribute("listaBienes",listaBienes);
        return "listaBienes";
    }
}
