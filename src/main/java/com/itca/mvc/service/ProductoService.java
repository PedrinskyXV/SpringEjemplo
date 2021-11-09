package com.itca.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itca.mvc.entity.Producto;
import com.itca.mvc.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductoService {
    @Autowired
    ProductoRepository repository;

    public void insertar(Producto producto)
    {
        repository.save(producto);
    }

    public List<Producto> listar()
    {
        return (List<Producto>) repository.findAll();
    }

    public void editar(Producto producto)
    {
        repository.save(producto);
    }

    public void eliminar(int id)
    {
        repository.deleteById(id);
    }

    public Producto obtener (int id)
    {
        return repository.findById(id).get();
    }
    
}
