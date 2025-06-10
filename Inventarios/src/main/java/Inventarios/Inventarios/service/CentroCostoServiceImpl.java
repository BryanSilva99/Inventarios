package Inventarios.Inventarios.service;

import Inventarios.Inventarios.entities.Bien;
import Inventarios.Inventarios.entities.CentroCosto;
import Inventarios.Inventarios.repositories.CentroCostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroCostoServiceImpl implements CentroCostoService {

    @Autowired
    private CentroCostoRepository centroCostoRepository;


    @Override
    public void agregarCentroCosto(CentroCosto centroCosto) {
        centroCostoRepository.save(centroCosto);
    }

    @Override
    public CentroCosto buscarBienPorId(Integer id) {
        return centroCostoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CentroCosto> listarBienes() {
        return centroCostoRepository.findAll();
    }

    @Override
    public void borrarBienPorId(Integer id) {
        centroCostoRepository.deleteById(id);
    }
}
