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
import java.util.Set;

@Controller
@SessionAttributes("ficha")
public class FichaController {

    @Autowired
    private CentroCostoService centroCostoService;

    @Autowired
    private FichaService fichaService;

    @Autowired
    private BienService bienService;

    @ModelAttribute("ficha")
    public Ficha crearFicha() {
        return new Ficha();  // Objeto que almacena toda la ficha completa
    }

    @GetMapping("/ficha")
    public String crearFicha(Model model){
        Ficha ficha = new Ficha();
        model.addAttribute("ficha",ficha);
        List<CentroCosto> centrosCosto = centroCostoService.listarCentrosCosto();
        model.addAttribute("listaCentrosCosto",centrosCosto);
        return "ficha";
    }


    @PostMapping("/fichaBienes")
    public String seleccionarBienes(@ModelAttribute("ficha")  Ficha ficha){
        return "redirect:/listaBienesSeleccion";
    }


    @PostMapping("/fichaResumen")
    public String guardarFicha(@RequestParam Set<Integer>bienesSeleccionados , @ModelAttribute("ficha") Ficha ficha){
        Set<Bien> bienes = bienService.encontrarBienesPorId(bienesSeleccionados);
        ficha.setBienes(bienes);
        fichaService.agregarFicha(ficha);
        return "redirect:/fichas";
    }

    @GetMapping("/fichas")
    public String listaFichas(@ModelAttribute("ficha")  Ficha ficha){
        return "fichas";
    }
}
