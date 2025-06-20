package Inventarios.Inventarios.service;

import Inventarios.Inventarios.entities.Bien;
import Inventarios.Inventarios.repositories.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BienServiceImpl implements BienService{

    @Autowired
    private BienRepository bienRepository;

    @Override
    public void agregarBien(Bien bien) {
        bienRepository.save(bien);
    }

    @Override
    public Bien buscarBienPorId(Integer id) {
        return bienRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Bien> listarBienes() {
        return bienRepository.findAll();
    }

    @Override
    public void borrarBienPorId(Integer id) {
        bienRepository.deleteById(id);
    }

    @Override
    public Set<Bien> encontrarBienesPorId(Set<Integer> bienesPorId) {
        return new HashSet<>(bienRepository.findAllById(bienesPorId));
    }


}
