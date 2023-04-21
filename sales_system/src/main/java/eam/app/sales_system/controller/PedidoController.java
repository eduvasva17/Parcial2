package eam.app.sales_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eam.app.sales_system.models.Pedido;
import eam.app.sales_system.service.ClienteService;
import eam.app.sales_system.service.PedidoService;
import eam.app.sales_system.service.VendedorService;
import jakarta.validation.Valid;

@Controller

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendedorService vendedorService;

    @GetMapping({ "/pedidos", "/" })
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "pedido/listar";
    }

    @GetMapping("/nuevo")
    public String nuevoPedido(Model model) {
        Pedido pedido = new Pedido();
        model.addAttribute("pedido", pedido);
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("vendedores", vendedorService.listarVendedores());

        return "pedido/nuevo";
    }

    @PostMapping("/pedidos")
    public String guardarPedido(@Valid Pedido pedido, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clientes", clienteService.listarClientes());
            model.addAttribute("vendedores", vendedorService.listarVendedores());
            return "pedido/nuevo";
        }
        pedidoService.guardarPedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedido/ver/{id}")
    public String verPedido(@PathVariable("id") long id, Model model) {
        Pedido pedido = pedidoService.obtenerPedidoPorId(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "pedido/ver";
        } else {
            return "redirect:/pedidos";
        }
    }

    @GetMapping("/pedido/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        model.addAttribute("pedido", pedidoService.obtenerPedidoPorId(id));
        model.addAttribute("fecha", pedidoService.obtenerPedidoPorId(id).getFecha());
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("vendedores", vendedorService.listarVendedores());
        return "pedido/editar";
    }

    @PostMapping("/pedidos/{id}")
    public String actualizarPedido(@PathVariable Long id, @ModelAttribute("pedido") Pedido pedido,
            Model modelo) {
        Pedido pedidoExistente = pedidoService.obtenerPedidoPorId(id);
        pedidoExistente.setId(id);
        pedidoExistente.setCantidad(pedido.getCantidad());
        pedidoExistente.setCliente(pedido.getCliente());
        pedidoExistente.setVendedor(pedido.getVendedor());
        pedidoExistente.setFecha(pedido.getFecha());

        pedidoService.actualizarPedido(pedidoExistente);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedido/eliminar/{id}")
    public String eliminarPedido(@PathVariable("id") long id) {

        pedidoService.eliminarPedido(id);
        
        return "redirect:/pedidos";
    }


}
