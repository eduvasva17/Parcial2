package eam.app.sales_system.service;

import java.util.List;

import eam.app.sales_system.models.Cliente;

public interface ClienteService {

    public List<Cliente> listarClientes();

    public Cliente guardarCliente(Cliente Cliente);

    public Cliente obtenerClientePorId(Long id);

    public Cliente actualizarCliente(Cliente Cliente);

    public void eliminarCliente(Long id);

    public int validacionPedidosCliente(Long id);

}
