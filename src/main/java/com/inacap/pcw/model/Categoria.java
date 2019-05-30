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
public class Categoria implements Crud{
    private int id;
    private String nombre;
    private ArrayList<Categoria> listaCategorias = new ArrayList();

    private Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Categoria() {}

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
    
    
    @Override
    public void agregar(Object object) {
        // Obtener el ultimo id
        int id;
        if(listaCategorias.isEmpty()) {
            id = 1;
        } else {
            id = listaCategorias.get(listaCategorias.size() - 1).id + 1;
        }
        
        // Crear y guardar el objeto
        Categoria categoria = (Categoria) object;
        categoria.id = id;
        listaCategorias.add(categoria);
    }
    

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList) this.listaCategorias;
    }
    

    @Override
    public void editar(int id, Object categoria) {
        Categoria categoriaEncontrada = (Categoria)categoria;
        
        for (Categoria category : listaCategorias) {
            if (category.id == id) {
                category.nombre = categoriaEncontrada.nombre;
                break;
            }
        }
    }
    

    @Override
    public void eliminar(int id) {
        for (Categoria category : listaCategorias) {
            if (category.id == id) {
                listaCategorias.remove(category);
                break;
            }
        }
    }
    

    @Override
    public Object buscar(int id) {
        Categoria encontrada = new Categoria();
        for (Categoria categoria : listaCategorias) {
            if (categoria.id == id) {
                encontrada= categoria;
                break;
            }
        }
        
        return encontrada;
    }
    
    
}
