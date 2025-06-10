package Inventarios.Inventarios.service;

import Inventarios.Inventarios.entities.Ficha;

import java.util.List;

public interface FichaService {
    void agregarBien(Ficha ficha);
    Ficha buscarBienPorId(Integer id);
    List<Ficha> listarBienes();
    void borrarBienPorId(Integer id);
}
