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
public class Ciudad implements Crud {
    private int id;
    private String nombre;
    private static ArrayList<Ciudad> listaCiudades;

    private Ciudad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Ciudad() {}

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
    public void agregar(Object ciudad) {
        // Obtener el ultimo id
        int id;
        if(listaCiudades.isEmpty()) {
            id = 1;
        } else {
            id = listaCiudades.get(listaCiudades.size() - 1).id + 1;
        }
        
        // Crear y guardar el objeto
        Ciudad city = (Ciudad) ciudad;
        city.id = id;
        listaCiudades.add(city);
    }
    

    @Override
    public ArrayList<Object> listar() {
        return (ArrayList) this.listaCiudades;
    }
    

    @Override
    public void editar(int id, Object ciudad) {
        Ciudad ciudadEncontrada = (Ciudad)ciudad;
        
        for (Ciudad city : listaCiudades) {
            if (city.id == id) {
                city.nombre = ciudadEncontrada.nombre;
                break;
            }
        }
    }
    

    @Override
    public void eliminar(int id) {
        for (Ciudad city : listaCiudades) {
            if (city.id == id) {
                listaCiudades.remove(city);
                break;
            }
        }
    }
    

    @Override
    public Object buscar(int id) {
        Ciudad encontrada = new Ciudad();
        for (Ciudad ciudad : listaCiudades) {
            if (ciudad.id == id) {
                encontrada= ciudad;
                break;
            }
        }
        
        return encontrada;
    }
    
    
    
}
