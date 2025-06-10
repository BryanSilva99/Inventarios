package Inventarios.Inventarios.repositories;

import Inventarios.Inventarios.entities.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BienRepository extends JpaRepository<Bien,Integer> {
}
