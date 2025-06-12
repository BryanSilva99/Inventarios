package Inventarios.Inventarios.controller;

import Inventarios.Inventarios.entities.CentroCosto;
import Inventarios.Inventarios.entities.Ficha;
import Inventarios.Inventarios.service.CentroCostoService;
import Inventarios.Inventarios.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FichaController {

    @Autowired
    private CentroCostoService centroCostoService;

    @Autowired
    private FichaService fichaService;

    @GetMapping("/ficha")
    public String crearFicha(Model model, LocalDateTime date){
        Ficha ficha = new Ficha();
        model.addAttribute("ficha",ficha);
        List<CentroCosto> centrosCosto = centroCostoService.listarCentrosCosto();
        model.addAttribute("listaCentrosCosto",centrosCosto);
        return "ficha";
    }

    @PostMapping("/ficha")
    public String guardarFicha(@ModelAttribute Ficha ficha){
        fichaService.agregarFicha(ficha);
        return "fichas";
    }
}
