/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.pcw.controller;

import com.inacap.pcw.model.Categoria;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author danielcandiapereira
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @GetMapping()
    public List<Categoria> list() {
        Categoria category = new Categoria();
        return (ArrayList) category.listar();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Categoria category = new Categoria();
        return category.buscar(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Categoria input) {
        Categoria category = new Categoria();
        category.editar(Integer.parseInt(id), input);
        return new ResponseEntity<>("Categoria editada", HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Categoria input) {
        Categoria category = new Categoria();
        category.agregar(input);
        return new ResponseEntity<>("Categoria agregado", HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Categoria category = new Categoria();
        category.eliminar(Integer.parseInt(id));
        return new ResponseEntity<>("Categoria eliminada", HttpStatus.OK);
    }
    
}
