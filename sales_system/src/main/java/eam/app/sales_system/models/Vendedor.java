package eam.app.sales_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;

    @Column(name = "apellido2", nullable = false, length = 50)
    private String apellido2;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Column(name = "comision", nullable = false, length = 50)
    private float comision;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    public Vendedor() {
        pedidos = new ArrayList<>();
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

}
