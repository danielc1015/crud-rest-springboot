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
public interface Crud {
    public void agregar(Object objeto);
    public ArrayList<Object> listar();
    public void editar(int id, Object objeto);
    public void eliminar(int id);
    public Object buscar(int id);
}
