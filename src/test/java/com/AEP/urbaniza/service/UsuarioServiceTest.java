package com.AEP.urbaniza.service;

import com.AEP.urbaniza.model.Usuario;
import com.AEP.urbaniza.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void criar_deveSalvarUsuario() {
        Usuario usuario = new Usuario();

        when(repository.save(usuario)).thenReturn(usuario);

        Usuario resultado = service.criar(usuario);

        assertEquals(usuario, resultado);
        verify(repository).save(usuario);
    }

    @Test
    void listarTodos_deveRetornarUsuarios() {
        Usuario usuario = new Usuario();

        when(repository.findAll()).thenReturn(List.of(usuario));

        List<Usuario> resultado = service.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals(usuario, resultado.get(0));
        verify(repository).findAll();
    }

    @Test
    void buscarPorId_deveRetornarUsuarioQuandoEncontrado() {
        String id = "123";
        Usuario usuario = new Usuario();
        usuario.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(usuario));

        Usuario resultado = service.buscarPorId(id);

        assertEquals(usuario, resultado);
        verify(repository).findById(id);
    }

    @Test
    void buscarPorId_deveRetornarNullQuandoNaoEncontrado() {
        String id = "999";

        when(repository.findById(id)).thenReturn(Optional.empty());

        Usuario resultado = service.buscarPorId(id);

        assertNull(resultado);
        verify(repository).findById(id);
    }

    @Test
    void atualizar_deveDefinirIdESalvarUsuario() {
        Usuario usuario = new Usuario();
        String id = "987";

        when(repository.save(usuario)).thenReturn(usuario);

        Usuario resultado = service.atualizar(id, usuario);

        assertEquals(id, resultado.getId());
        verify(repository).save(usuario);
    }

    @Test
    void deletar_deveDeletarPorId() {
        String id = "987";

        service.deletar(id);

        verify(repository).deleteById(id);
    }
}