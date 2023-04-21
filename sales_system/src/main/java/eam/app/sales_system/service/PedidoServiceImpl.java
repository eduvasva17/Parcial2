package eam.app.sales_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eam.app.sales_system.models.Cliente;
import eam.app.sales_system.models.Pedido;
import eam.app.sales_system.repositorie.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
   
    @Autowired
    private PedidoRepository pedidoRepo;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepo.findAll();
    }

    @Override
    public Pedido guardarPedido(Pedido Pedido) {
        return pedidoRepo.save(Pedido);
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepo.findById(id).get();
    }

    @Override
    public Pedido actualizarPedido(Pedido Pedido) {
        return pedidoRepo.save(Pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepo.deleteById(id);
    }

    @Override
    public List<Cliente> obtenerClientesConPedidos() {
        return pedidoRepo.obtenerClientesConPedidos();
    }

}
