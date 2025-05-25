package Inventarios.Inventarios.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private List<Bien> bienes;
    private String usuario;
    private String sede;
    private String centroDeCosto;
    private String jefedeCentrodeCosto;
    private String ubicacionFisica;
    private String tipoDeVerificacion;
    private Date date;
    private Integer equipodeInventario;
}
