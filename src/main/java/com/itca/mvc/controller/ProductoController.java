package com.itca.mvc.controller;

import javax.validation.Valid;

import com.itca.mvc.entity.Producto;
import com.itca.mvc.repository.MarcaRepository;
import com.itca.mvc.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Anotación indica que una clase en particular cumple la función de controlador.
@RequestMapping("/productos/") // Anotación para mapear URL
public class ProductoController {

    @Autowired // Inyecta dependencias dentro de Spring.
    private ProductoService productoService;

    @Autowired // Inyecta dependencias dentro de Spring.
    private MarcaRepository marcaRepository;
    
    

    @GetMapping("agregarProducto")
    public String mostrarFormProducto(Producto producto, Model model) {
        model.addAttribute("marcas", this.marcaRepository.findAll());
        return "agregarProducto";
    }
    
    @GetMapping("/")
    public String productos(Model model) {
        model.addAttribute("productos", this.productoService.listar());        
        return "index";
    }

    @PostMapping("agregar")
    public String agregarProducto(@Valid Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "agregarProducto";
        }
        this.productoService.insertar(producto);
               
        return "redirect:/productos/";
    }

    @GetMapping("editar/{codigo}")
    public String editarProducto(@PathVariable("codigo") int codigo, Model model) {
        Producto producto = this.productoService.obtener(codigo);                
        model.addAttribute("producto", producto);
        model.addAttribute("marcas", this.marcaRepository.findAll());
        return "editarProducto";
    }

    @PostMapping("modificar/{codigo}")
    public String modificar(@PathVariable("codigo") int codigo, @Valid Producto producto, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            producto.setCodigo(codigo);
            return "editarProducto";
        }
        this.productoService.editar(producto);
        return "redirect:/productos/";
    }

    @GetMapping("eliminar/{codigo}")
    public String eliminar(@PathVariable("codigo") int codigo, Model model) {
        this.productoService.eliminar(codigo);
        return "redirect:/productos/";
    }

}