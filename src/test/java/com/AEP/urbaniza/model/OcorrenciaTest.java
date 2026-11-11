package com.AEP.urbaniza.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OcorrenciaTest {

    @Test
    void deveDefinirERetornarId() {
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setId("123");

        assertEquals("123", ocorrencia.getId());
    }

    @Test
    void deveDefinirERetornarDescricao() {
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setDescricao("Buraco na rua");

        assertEquals("Buraco na rua", ocorrencia.getDescricao());
    }

    @Test
    void deveDefinirERetornarCategoria() {
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setCategoria("BURACO");

        assertEquals("BURACO", ocorrencia.getCategoria());
    }

    @Test
    void deveDefinirERetornarStatus() {
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setStatus("ABERTA");

        assertEquals("ABERTA", ocorrencia.getStatus());
    }

    @Test
    void deveDefinirERetornarUsuarioId() {
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setUsuarioId("usuario123");

        assertEquals("usuario123", ocorrencia.getUsuarioId());
    }

    @Test
    void deveDefinirERetornarLocalizacao() {
        Ocorrencia ocorrencia = new Ocorrencia();
        Localizacao localizacao = new Localizacao();

        localizacao.setCidade("Maringá");
        ocorrencia.setLocalizacao(localizacao);

        assertEquals(localizacao, ocorrencia.getLocalizacao());
        assertEquals("Maringá", ocorrencia.getLocalizacao().getCidade());
    }
}