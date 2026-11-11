package com.AEP.urbaniza.controller;

import com.AEP.urbaniza.model.Usuario;
import com.AEP.urbaniza.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/usuarios")
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.criar(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizar(@PathVariable String id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}