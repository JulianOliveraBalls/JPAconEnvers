package entidades;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;
import org.hibernate.envers.Audited;

@Builder
@Data
@Entity
@Table(name = "domicilio")
@Audited
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_calle")
    private String nombreCalle;

    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
}