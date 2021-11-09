package com.itca.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @NotNull(message = "El nombre del producto es requerido.")
    @Size(min = 2, message = "El nombre debe de tener como minimo 2 caracteres.")
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    @NotNull(message = "El precio del producto es requerido.")
    private double precio;
    @Column(name = "estado")
    private int estado;

    @ManyToOne(optional = false)
    @JoinColumn(name="marca")
    @NotNull(message = "La marca es requerida.")
    private Marca marca;

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int estado, Marca marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }            
}