package Inventarios.Inventarios.repositories;

import Inventarios.Inventarios.entities.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<Ficha,Integer> {
}
