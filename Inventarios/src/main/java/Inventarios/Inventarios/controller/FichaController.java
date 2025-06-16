package Inventarios.Inventarios.controller;

import Inventarios.Inventarios.entities.Bien;
import Inventarios.Inventarios.entities.CentroCosto;
import Inventarios.Inventarios.entities.Ficha;
import Inventarios.Inventarios.service.BienService;
import Inventarios.Inventarios.service.CentroCostoService;
import Inventarios.Inventarios.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes("ficha")
public class FichaController {

    @Autowired
    private CentroCostoService centroCostoService;

    @Autowired
    private FichaService fichaService;

    @Autowired
    private BienService bienService;

    @ModelAttribute("fichaForm")
    public Ficha crearFicha() {
        return new Ficha();  // Objeto que almacena toda la ficha completa
    }

    @GetMapping("/ficha")
    public String crearFicha(Model model, LocalDateTime date){
        Ficha ficha = new Ficha();
        model.addAttribute("ficha",ficha);
        List<CentroCosto> centrosCosto = centroCostoService.listarCentrosCosto();
        List<Bien> listaBienes = bienService.listarBienes();
        model.addAttribute("listaCentrosCosto",centrosCosto);
        model.addAttribute("listaBienes",listaBienes);
        return "ficha";
    }

    @PostMapping("/ficha")
    public String guardarFicha(@RequestParam List<Integer>bienesSeleccionados , @ModelAttribute Ficha ficha){
        List<Bien> bienes = bienService.encontrarBienesPorId(bienesSeleccionados);
        ficha.setBienes(bienes);
        fichaService.agregarFicha(ficha);
        return "redirect:/ficha";
    }
}
