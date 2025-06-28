package Inventarios.Inventarios.entities;

import jakarta.persistence.*;
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
                uniqueConstraints = @UniqueConstraint(columnNames = {"ficha_id","bien_id"})// el constraint de aqui evita que se cree un elemento duplicado o repetido en la tabla M to M con la combinacion ficha_id-bien_id
        )                                                                                       //  aqui se establece como se creara la tabla intermedia para llevar acabo la relacion many to many
    private Set<Bien> bienes;
    @OneToOne
    private Inventarista inventarista;
    private String sede;
    @ManyToOne          //  varias fichas pueden tener el mismo centro de costo , pero una ficha puede tener un solo centro de costo;
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
