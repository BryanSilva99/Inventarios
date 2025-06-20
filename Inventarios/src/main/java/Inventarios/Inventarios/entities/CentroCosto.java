package Inventarios.Inventarios.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "centcosto")
public class CentroCosto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String nombreDeJefe;
    private String codigo;

    @Override
    public String toString() {
        return nombre;
    }
}
