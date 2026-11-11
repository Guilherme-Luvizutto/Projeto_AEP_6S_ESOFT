package com.AEP.urbaniza.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveDefinirERetornarId() {
        Usuario usuario = new Usuario();

        usuario.setId("123");

        assertEquals("123", usuario.getId());
    }

    @Test
    void deveDefinirERetornarNome() {
        Usuario usuario = new Usuario();

        usuario.setNome("João");

        assertEquals("João", usuario.getNome());
    }

    @Test
    void deveDefinirERetornarEmail() {
        Usuario usuario = new Usuario();

        usuario.setEmail("joao@email.com");

        assertEquals("joao@email.com", usuario.getEmail());
    }
}