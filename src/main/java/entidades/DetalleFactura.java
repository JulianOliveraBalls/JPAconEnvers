package entidades;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;
import org.hibernate.envers.Audited;

@Builder
@Data
@Entity
@Table(name = "detalle_factura")
@Audited
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private int subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "detalle_fk_factura")
    private Factura factura;
}
