/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.pcw.controller;

import com.inacap.pcw.model.Ciudad;
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
@RequestMapping("/ciudad")
public class CiudadController {
    
    @GetMapping()
    public List<Ciudad> list() {
        Ciudad city = new Ciudad();
        return (ArrayList) city.listar();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Ciudad city = new Ciudad();
        return city.buscar(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Ciudad input) {
        Ciudad city = new Ciudad();
        city.editar(Integer.parseInt(id), input);
        return new ResponseEntity<>("Ciudad editada", HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Ciudad input) {
        Ciudad city = new Ciudad();
        city.agregar(input);
        return new ResponseEntity<>("Ciudad agregado", HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Ciudad city = new Ciudad();
        city.eliminar(Integer.parseInt(id));
        return new ResponseEntity<>("Ciudad eliminado", HttpStatus.OK);
    }
    
}
