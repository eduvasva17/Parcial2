package eam.app.sales_system.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;


import eam.app.sales_system.models.Vendedor;


public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
