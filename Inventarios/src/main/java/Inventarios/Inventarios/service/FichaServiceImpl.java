package Inventarios.Inventarios.service;

import Inventarios.Inventarios.entities.Ficha;
import Inventarios.Inventarios.repositories.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaServiceImpl implements FichaService{

    @Autowired
    private FichaRepository fichaRepository;

    @Override
    public void agregarBien(Ficha ficha) {
        fichaRepository.save(ficha);
    }

    @Override
    public Ficha buscarBienPorId(Integer id) {
        return fichaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Ficha> listarBienes() {
        return fichaRepository.findAll();
    }

    @Override
    public void borrarBienPorId(Integer id) {
        fichaRepository.deleteById(id);
    }
}
