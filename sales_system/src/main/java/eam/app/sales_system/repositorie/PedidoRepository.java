package eam.app.sales_system.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eam.app.sales_system.models.Cliente;
import eam.app.sales_system.models.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value="SELECT c FROM Cliente c LEFT JOIN c.pedidos p ORDER BY c.apellido1, c.apellido2, c.nombre",nativeQuery=true)
    List<Cliente> obtenerClientesConPedidos();

}

