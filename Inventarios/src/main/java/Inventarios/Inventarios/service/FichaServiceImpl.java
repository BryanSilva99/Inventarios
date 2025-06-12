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
    public void agregarFicha(Ficha ficha) {
        fichaRepository.save(ficha);
    }

    @Override
    public Ficha buscarFichaPorId(Integer id) {
        return fichaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Ficha> listarFichas() {
        return fichaRepository.findAll();
    }

    @Override
    public void borrarFichaPorId(Integer id) {
        fichaRepository.deleteById(id);
    }
}
