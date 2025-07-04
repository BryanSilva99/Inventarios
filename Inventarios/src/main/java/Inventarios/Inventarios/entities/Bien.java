package Inventarios.Inventarios.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String codigoAnterior;
    @Column(unique = true)
    private String codigoPatrimonial;
    @Column(unique = true)
    private String codigoActual;
    private String denominacion;
    private String marca;
    private String modelo;
    private String tipo;
    private String color;
    @Column(unique = true)
    private String serie;
    private String dimensiones;
    private Character situacion;
    private Character estado;
    private String observaciones;
    @ManyToMany(mappedBy = "bienes")            // la relacion es many to many porque un bien podria existir en multiples fichas y una ficha puede tener muchos bienes;
    private Set<Ficha> fichas = new HashSet<>();    // se cambio el uso de List por Set para evitar el duplicado de elementos
}
