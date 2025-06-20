package Inventarios.Inventarios.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
        @JoinTable(
                name="ficha_bienes",
                joinColumns = @JoinColumn(name="ficha_id"),
                inverseJoinColumns = @JoinColumn(name = "bien_id"),
                uniqueConstraints = @UniqueConstraint(columnNames = {"ficha_id","bien_id"})
        )
    private Set<Bien> bienes;
    @OneToOne
    private Usuario usuario;
    private String sede;
    @ManyToOne
    @JoinColumn(name = "centro_de_costo_id")
    private CentroCosto centroDeCosto;
    private String ubicacionFisica;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    public Ficha(){
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Ficha{id=" + id + ", sede='" + sede + "'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ficha)) return false;
        Ficha other = (Ficha) o;
        return Objects.equals(this.id, other.id);
    }

}
