package eam.app.sales_system.service;

import java.util.List;

import eam.app.sales_system.models.Cliente;
import eam.app.sales_system.models.Pedido;

public interface PedidoService {
    public List<Pedido> listarPedidos();

    public Pedido guardarPedido(Pedido Pedido);

    public Pedido obtenerPedidoPorId(Long id);

    public Pedido actualizarPedido(Pedido Pedido);

    public void eliminarPedido(Long id);

    public List<Cliente> obtenerClientesConPedidos();

}
