package eam.app.sales_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eam.app.sales_system.models.Vendedor;
import eam.app.sales_system.repositorie.VendedorRepository;

@Service
public class VendedorServiceImpl implements VendedorService {

    @Autowired
    private VendedorRepository repositorio;

    @Override
    public List<Vendedor> listarVendedores() {
        return repositorio.findAll();
    }

    @Override
    public Vendedor guardarVendedor(Vendedor vendedor) {
        return repositorio.save(vendedor);
    }

    @Override
    public Vendedor obtenerVendedorPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) {
        return repositorio.save(vendedor);
    }

    @Override
    public void eliminarVendedor(Long id) {
        repositorio.deleteById(id);
    }

}
