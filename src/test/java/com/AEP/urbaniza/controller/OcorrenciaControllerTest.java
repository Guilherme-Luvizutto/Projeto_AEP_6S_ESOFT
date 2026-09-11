package com.AEP.urbaniza.controller;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.service.OcorrenciaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OcorrenciaControllerTest {

    @Mock
    private OcorrenciaService service;

    @InjectMocks
    private OcorrenciaController controller;

    @Test
    void criar_deveRetornarOcorrencia() {
        Ocorrencia ocorrencia = new Ocorrencia();

        when(service.criar(ocorrencia)).thenReturn(ocorrencia);

        Ocorrencia resultado = controller.criar(ocorrencia);

        assertEquals(ocorrencia, resultado);
        verify(service).criar(ocorrencia);
    }

    @Test
    void listarTodos_deveRetornarOcorrencias() {
        Ocorrencia ocorrencia = new Ocorrencia();

        when(service.listarTodos()).thenReturn(List.of(ocorrencia));

        List<Ocorrencia> resultado = controller.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals(ocorrencia, resultado.get(0));
        verify(service).listarTodos();
    }

    @Test
    void buscarPorId_deveRetornarOcorrencia() {
        String id = "123";
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(id);

        when(service.buscarPorId(id)).thenReturn(ocorrencia);

        Ocorrencia resultado = controller.buscarPorId(id);

        assertEquals(ocorrencia, resultado);
        verify(service).buscarPorId(id);
    }

    @Test
    void atualizar_deveRetornarOcorrenciaAtualizada() {
        String id = "123";
        Ocorrencia ocorrencia = new Ocorrencia();

        when(service.atualizar(id, ocorrencia)).thenReturn(ocorrencia);

        Ocorrencia resultado = controller.atualizar(id, ocorrencia);

        assertEquals(ocorrencia, resultado);
        verify(service).atualizar(id, ocorrencia);
    }

    @Test
    void deletar_deveChamarService() {
        String id = "123";

        controller.deletar(id);

        verify(service).deletar(id);
    }
}
