package com.AEP.urbaniza.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalizacaoTest {

    @Test
    void deveDefinirERetornarRua() {
        Localizacao localizacao = new Localizacao();

        localizacao.setRua("Rua das Flores");

        assertEquals("Rua das Flores", localizacao.getRua());
    }

    @Test
    void deveDefinirERetornarBairro() {
        Localizacao localizacao = new Localizacao();

        localizacao.setBairro("Centro");

        assertEquals("Centro", localizacao.getBairro());
    }

    @Test
    void deveDefinirERetornarNumero() {
        Localizacao localizacao = new Localizacao();

        localizacao.setNumero("123");

        assertEquals("123", localizacao.getNumero());
    }

    @Test
    void deveDefinirERetornarCidade() {
        Localizacao localizacao = new Localizacao();

        localizacao.setCidade("Maringá");

        assertEquals("Maringá", localizacao.getCidade());
    }
}