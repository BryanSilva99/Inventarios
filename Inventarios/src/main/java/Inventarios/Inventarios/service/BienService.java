package Inventarios.Inventarios.service;

import Inventarios.Inventarios.entities.Bien;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BienService {
    void agregarBien(Bien bien);
    Bien buscarBienPorId(Integer id);
    List<Bien> listarBienes();
    void borrarBienPorId(Integer id);
}
