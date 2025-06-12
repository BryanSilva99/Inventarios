package Inventarios.Inventarios.service;

import Inventarios.Inventarios.entities.Bien;
import Inventarios.Inventarios.entities.CentroCosto;

import java.util.List;

public interface CentroCostoService {
    void agregarCentroCosto(CentroCosto centroCosto);
    CentroCosto buscarBienPorId(Integer id);
    List<CentroCosto> listarCentrosCosto();
    void borrarBienPorId(Integer id);
}
