package com.AEP.urbaniza.controller;

import com.AEP.urbaniza.model.Usuario;
import com.AEP.urbaniza.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @Mock
    private UsuarioService service;

    @InjectMocks
    private UsuarioController controller;

    @Test
    void criar_deveRetornarUsuario() {
        Usuario usuario = new Usuario();

        when(service.criar(usuario)).thenReturn(usuario);

        Usuario resultado = controller.criar(usuario);

        assertEquals(usuario, resultado);
        verify(service).criar(usuario);
    }

    @Test
    void listarTodos_deveRetornarUsuarios() {
        Usuario usuario = new Usuario();

        when(service.listarTodos()).thenReturn(List.of(usuario));

        List<Usuario> resultado = controller.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals(usuario, resultado.get(0));
        verify(service).listarTodos();
    }

    @Test
    void buscarPorId_deveRetornarUsuario() {
        String id = "123";
        Usuario usuario = new Usuario();
        usuario.setId(id);

        when(service.buscarPorId(id)).thenReturn(usuario);

        Usuario resultado = controller.buscarPorId(id);

        assertEquals(usuario, resultado);
        verify(service).buscarPorId(id);
    }

    @Test
    void atualizar_deveRetornarUsuarioAtualizado() {
        String id = "123";
        Usuario usuario = new Usuario();

        when(service.atualizar(id, usuario)).thenReturn(usuario);

        Usuario resultado = controller.atualizar(id, usuario);

        assertEquals(usuario, resultado);
        verify(service).atualizar(id, usuario);
    }

    @Test
    void deletar_deveChamarService() {
        String id = "123";

        controller.deletar(id);

        verify(service).deletar(id);
    }
}