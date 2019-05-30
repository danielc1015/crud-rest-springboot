/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.pcw.controller;

import com.inacap.pcw.model.Producto;
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
@RequestMapping("/producto")
public class ProductoController {
    
    @GetMapping()
    public List<Producto> list() {
        Producto product = new Producto();
        return (ArrayList) product.listar();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Producto product = new Producto();
        return product.buscar(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Producto input) {
        Producto product = new Producto();
        product.editar(Integer.parseInt(id), input);
        return new ResponseEntity<>("Producto editado", HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Producto input) {
        Producto product = new Producto();
        product.agregar(input);
        return new ResponseEntity<>("Producto agregado", HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Producto product = new Producto();
        product.eliminar(Integer.parseInt(id));
        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
    }
    
}
