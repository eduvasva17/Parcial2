package eam.app.sales_system.service;

import java.util.List;

import eam.app.sales_system.models.Vendedor;

public interface VendedorService {

    public List<Vendedor> listarVendedores();

    public Vendedor guardarVendedor(Vendedor Vendedor);

    public Vendedor obtenerVendedorPorId(Long id);

    public Vendedor actualizarVendedor(Vendedor Vendedor);

    public void eliminarVendedor(Long id);
}
