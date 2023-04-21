package eam.app.sales_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eam.app.sales_system.models.Cliente;
import eam.app.sales_system.repositorie.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    public ClienteRepository clienteRepo;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepo.findById(id).get();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public int validacionPedidosCliente(Long id) {
        List <Cliente> clientes;

        clientes=clienteRepo.validacionPedidosCliente(id);
        int total=clientes.size();
        return total;

    }




}
