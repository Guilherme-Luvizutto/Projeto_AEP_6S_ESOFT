package com.AEP.urbaniza.service;

import com.AEP.urbaniza.model.Usuario;
import com.AEP.urbaniza.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario criar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    public Usuario atualizar(String id, Usuario usuario) {
        usuario.setId(id);
        return repository.save(usuario);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}