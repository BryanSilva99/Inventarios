package Inventarios.Inventarios.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private List<Bien> bienes;
    @OneToOne
    private Usuario usuario;
    private String sede;
    @OneToOne
    private CentroCosto centroDeCosto;
    private String ubicacionFisica;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    public Ficha(){
        this.date = LocalDate.now();
    }



}
