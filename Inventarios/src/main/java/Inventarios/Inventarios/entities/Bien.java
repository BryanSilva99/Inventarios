package Inventarios.Inventarios.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigoAnterior;
    private String codigoPatrimonial;
    private String codigoActual;
    private String denominacion;
    private String marca;
    private String modelo;
    private String tipo;
    private String color;
    private String serie;
    private String dimensiones;
    private Character situacion;
    private Character estado;
    private String observaciones;
}
