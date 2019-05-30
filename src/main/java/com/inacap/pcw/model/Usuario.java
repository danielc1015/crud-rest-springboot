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
public class Usuario implements Crud {
    
    private int id;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private static ArrayList<Usuario> listaUsuarios = new ArrayList();
    
    public Usuario() {}

    private Usuario(int id, String nombre, String apellido, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }
    
    public Usuario(String nombre, String apellido, Ciudad ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     *
     * @param usuario
     */
    @Override
    public void agregar(Object usuario) {
        // Obtener el ultimo id
        int idGenerado;
        if(listaUsuarios.isEmpty()) {
            idGenerado = 1;
        } else {
            idGenerado = listaUsuarios.get(listaUsuarios.size() - 1).id + 1;
        }
        
        // Crear y guardar el objeto
        Usuario user = (Usuario) usuario;
        user.id = idGenerado;
        listaUsuarios.add(user);
    }

    
    /**
     *
     * @return listaUsuarios
     */
    @Override
    public ArrayList<Object> listar() {
        return (ArrayList) listaUsuarios;
    }
    
    /**
     *
     * @param id
     * @param usuario
     */
    @Override
    public void editar(int id, Object usuario) {
        Usuario usuarioEditado = (Usuario)usuario;
        
        for (Usuario user : listaUsuarios) {
            if (user.id == id) {
                user.nombre = usuarioEditado.nombre;
                user.apellido = usuarioEditado.apellido;
                user.ciudad = usuarioEditado.ciudad;
                break;
            }
        }
    }
    
    /**
     *
     * @param id
     */
    @Override
    public void eliminar(int id) {
        for (Usuario user : listaUsuarios) {
            if (user.id == id) {
                listaUsuarios.remove(user);
                break;
            }
        }
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Object buscar(int idB) {
        Usuario encontrado = new Usuario();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.id == idB) {
                encontrado = usuario;
                break;
            }
        }
        
        return encontrado;
    }
    
    
    
    
     
}
