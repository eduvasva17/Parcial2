package eam.app.sales_system.repositorie;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import eam.app.sales_system.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query(value="select c.* from Cliente c join Pedido p on c.id=p.id_cliente where c.id=:ID",nativeQuery=true)
    //@Query("select * from cliente", nativeQuery=true)
    List<Cliente> validacionPedidosCliente(@Param("ID") Long ID);
}
