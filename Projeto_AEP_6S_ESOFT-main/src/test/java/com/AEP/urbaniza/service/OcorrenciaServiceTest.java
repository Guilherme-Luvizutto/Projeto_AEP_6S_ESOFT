package com.AEP.urbaniza.service;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.repository.OcorrenciaRepository;
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
public class OcorrenciaServiceTest {

    @Mock
    private OcorrenciaRepository repository;

    @InjectMocks
    private OcorrenciaService service;

    @Test
    void criar_deveSalvarOcorrencia() {
        Ocorrencia ocorrencia = new Ocorrencia();

        when(repository.save(ocorrencia)).thenReturn(ocorrencia);

        Ocorrencia resultado = service.criar(ocorrencia);

        assertEquals(ocorrencia, resultado);
        verify(repository).save(ocorrencia);
    }

    @Test
    void listarTodos_deveRetornarOcorrencias() {
        Ocorrencia ocorrencia = new Ocorrencia();

        when(repository.findAll()).thenReturn(List.of(ocorrencia));

        List<Ocorrencia> resultado = service.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals(ocorrencia, resultado.get(0));
        verify(repository).findAll();
    }

    @Test
    void buscarPorId_deveRetornarOcorrenciaQuandoEncontrada() {
        String id = "123";
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(ocorrencia));

        Ocorrencia resultado = service.buscarPorId(id);

        assertEquals(ocorrencia, resultado);
        verify(repository).findById(id);
    }

    @Test
    void buscarPorId_deveRetornarNullQuandoNaoEncontrada() {
        String id = "999";

        when(repository.findById(id)).thenReturn(Optional.empty());

        Ocorrencia resultado = service.buscarPorId(id);

        assertNull(resultado);
        verify(repository).findById(id);
    }

    @Test
    void atualizar_deveDefinirIdESalvarOcorrencia() {
        Ocorrencia ocorrencia = new Ocorrencia();

        String id = "987";

        when(repository.save(ocorrencia)).thenReturn(ocorrencia);

        Ocorrencia resultado = service.atualizar(id, ocorrencia);

        assertEquals(id, resultado.getId());

        verify(repository).save(ocorrencia);
    }

    @Test
    void deletar_deveDeletarPorId() {
        String id = "987";

        service.deletar(id);

        verify(repository).deleteById(id);
    }

}