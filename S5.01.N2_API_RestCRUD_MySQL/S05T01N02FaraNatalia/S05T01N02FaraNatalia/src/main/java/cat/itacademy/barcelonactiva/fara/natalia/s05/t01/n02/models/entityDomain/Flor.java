package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.entityDomain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity
@Table (name = "flor")
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pk_FlorID;
    @Column
    private String nameFlor;
    @Column
    private String paisFlor;


}
