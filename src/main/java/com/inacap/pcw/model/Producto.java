/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.pcw.model;

import java.util.ArrayList;

/**
 *
 * @author danielcandiapereira
 */
public class Producto implements Crud {
    private static ArrayList<Producto> listaProductos = new ArrayList();
    
    private int id;
    private String nombre;
    private long precio;
    private int stock;
    private Categoria categoria;
    private String detalle;

    public Producto() {}

    private Producto(int id, String nombre, long precio, int stock, Categoria categoria, String detalle) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    
    @Override
    public void agregar(Object producto) {
        // Obtener el ultimo id
        int idGenerado;
        if(listaProductos.isEmpty()) {
            idGenerado = 1;
        } else {
            idGenerado = listaProductos.get(listaProductos.size() - 1).id + 1;
        }
        
        // Crear y guardar el objeto
        Producto product = (Producto) producto;
        product.id = idGenerado;
        listaProductos.add(product);
    }

    

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList) listaProductos;
    }
    

    @Override
    public void editar(int id, Object producto) {
        Producto productoEditado = (Producto)producto;
        
        for (Producto product : listaProductos) {
            if (product.id == id) {
                product.nombre = productoEditado.nombre;
                product.precio = productoEditado.precio;
                product.stock = productoEditado.stock;
                product.categoria = productoEditado.categoria;
                product.detalle = productoEditado.detalle;
                break;
            }
        }
    }
    
    
    @Override
    public void eliminar(int id) {
        for (Producto product : listaProductos) {
            if (product.id == id) {
                listaProductos.remove(product);
                break;
            }
        }
    }
    
    
    @Override
    public Object buscar(int idB) {
        Producto encontrado = new Producto();
        for (Producto producto : listaProductos) {
            if (producto.id == idB) {
                encontrado = producto;
                break;
            }
        }
        
        return encontrado;
    }
    
    
    
    
}
