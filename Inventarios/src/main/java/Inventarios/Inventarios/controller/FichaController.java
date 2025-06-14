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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FichaController {

    @Autowired
    private CentroCostoService centroCostoService;

    @Autowired
    private FichaService fichaService;

    @Autowired
    private BienService bienService;

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
        return "fichas";
    }
}
