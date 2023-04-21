package eam.app.sales_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eam.app.sales_system.models.Vendedor;
import eam.app.sales_system.service.VendedorService;

@Controller
public class VendedorController {
    @Autowired
    private VendedorService vendedorService;

    @GetMapping("/vendedores")
    public String listarVendedores(Model model) {
        model.addAttribute("vendedoreslista", vendedorService.listarVendedores());
        return "vendedor/listar";
    }

    @GetMapping("/vendedor/ver/{id}")
    public String vervendedor(@PathVariable("id") long id, Model model) {
        Vendedor vendedor = vendedorService.obtenerVendedorPorId(id);
        if (vendedor != null) {
            model.addAttribute("vendedor", vendedor);
            return "vendedor/ver";
        } else {
            return "redirect:/vendedores";
        }
    }

   
    @GetMapping("nuevo/vendedor")
    public String nuevoVendedor(Model modelo) {
        Vendedor vendedor = new Vendedor();
        modelo.addAttribute("vendedor", vendedor);
        return "vendedor/nuevo";
    }

    @PostMapping("/vendedores")
    public String guardarvendedor(@ModelAttribute("vendedor") Vendedor vendedor) {
        vendedorService.guardarVendedor(vendedor);
        return "redirect:/vendedores";
    }

    @GetMapping("/vendedor/editar/{id}")
    public String Editarvendedor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("vendedor", vendedorService.obtenerVendedorPorId(id));
        return "vendedor/editar";
    }


    @PostMapping("/vendedores/{id}")
    public String actualizarvendedor(@PathVariable Long id, @ModelAttribute("vendedor") Vendedor vendedor,
            Model modelo) {
        Vendedor vendedorExistente = vendedorService.obtenerVendedorPorId(id);
        vendedorExistente.setId(id);
        vendedorExistente.setNombre(vendedor.getNombre());
        vendedorExistente.setApellido1(vendedor.getApellido1());
        vendedorExistente.setApellido2(vendedor.getApellido2());
        vendedorExistente.setCiudad(vendedor.getCiudad());
        vendedorExistente.setComision(vendedor.getComision());
        vendedorService.actualizarVendedor(vendedorExistente);
        return "redirect:/Vendedores";
    }

    @GetMapping("/vendedor/eliminar/{id}")
    public String eliminarvendedor(@PathVariable("id") long id) {
        vendedorService.eliminarVendedor(id);
        return "redirect:/vendedores";
    }
}
