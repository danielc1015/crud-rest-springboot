/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.pcw.controller;

import com.inacap.pcw.model.Ciudad;
import com.inacap.pcw.model.Usuario;
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
@RequestMapping("/usuario")
public class UsuarioController {
    
    @GetMapping()
    public List<Usuario> list() {
        Usuario user = new Usuario();
        return (ArrayList) user.listar();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Usuario user = new Usuario();
        return user.buscar(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Usuario input) {
        Usuario user = new Usuario();
        user.editar(Integer.parseInt(id), input);
        return new ResponseEntity<>("Usuario editado", HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Usuario input) {
        Usuario user = new Usuario();
        user.agregar(input);
        return new ResponseEntity<>("Usuario agregado", HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Usuario user = new Usuario();
        user.eliminar(Integer.parseInt(id));
        return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
    }
    
}
