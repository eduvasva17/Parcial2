package eam.app.sales_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eam.app.sales_system.models.Cliente;
import eam.app.sales_system.service.ClienteService;
import eam.app.sales_system.service.PedidoService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clienteslista", clienteService.listarClientes());
        return "cliente/listar";
    }

    @GetMapping("/cliente/ver/{id}")
    public String vercliente(@PathVariable("id") long id, Model model) {
        Cliente cliente = clienteService.obtenerClientePorId(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente/ver";
        } else {
            return "redirect:/clientes";
        }
    }

   
    @GetMapping("nuevo/cliente")
    public String nuevoCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "cliente/nuevo";
    }

    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/editar/{id}")
    public String EditarCliente(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.obtenerClientePorId(id));
        return "cliente/editar";
    }


    @PostMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente,
            Model modelo) {
        Cliente clienteExistente = clienteService.obtenerClientePorId(id);
        clienteExistente.setId(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido1(cliente.getApellido1());
        clienteExistente.setApellido2(cliente.getApellido2());
        clienteExistente.setCiudad(cliente.getCiudad());
        clienteExistente.setCategoria(cliente.getCategoria());
        clienteService.actualizarCliente(clienteExistente);
        return "redirect:/clientes";
    }

    @GetMapping("/cliente/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") long id) {
        //invocar la validacion
        if (clienteService.validacionPedidosCliente(id)>0)
            return "cliente/errorCliente";
        else {
            clienteService.eliminarCliente(id);
            return "redirect:/clientes";
        }
    }

    @GetMapping("/clientes-con-pedidos")
    public String clientesConPedidos(Model model) {
        model.addAttribute("clientesPedidos", pedidoService.obtenerClientesConPedidos());
        return "cliente/clientes_con_pedidos";
    }
}

