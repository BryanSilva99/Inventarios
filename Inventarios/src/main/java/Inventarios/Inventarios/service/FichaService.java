package Inventarios.Inventarios.service;

import Inventarios.Inventarios.entities.Ficha;

import java.util.List;

public interface FichaService {
    void agregarFicha(Ficha ficha);
    Ficha buscarFichaPorId(Integer id);
    List<Ficha> listarFichas();
    void borrarFichaPorId(Integer id);
}
