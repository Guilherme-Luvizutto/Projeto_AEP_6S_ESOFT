package com.AEP.urbaniza.console;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.service.OcorrenciaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuConsoleTest {

    @Mock
    private OcorrenciaService service;

    @Test
    void opcao1_deveCadastrarOcorrencia() {
        String entrada = """
            1
            Buraco na rua
            BURACO
            ABERTA
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        MenuConsole menu = new MenuConsole(service);

        menu.run();

        verify(service).criar(any(com.AEP.urbaniza.model.Ocorrencia.class));
    }

    @Test
    void opcao2_deveListarOcorrencias() {
        String entrada = """
            2
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        com.AEP.urbaniza.model.Ocorrencia ocorrencia =
                new com.AEP.urbaniza.model.Ocorrencia();

        ocorrencia.setId("123");
        ocorrencia.setDescricao("Buraco na rua");
        ocorrencia.setCategoria("BURACO");
        ocorrencia.setStatus("ABERTA");

        when(service.listarTodos()).thenReturn(java.util.List.of(ocorrencia));

        MenuConsole menu = new MenuConsole(service);

        menu.run();

        verify(service).listarTodos();
    }

    @Test
    void opcaoInvalida_deveMostrarMensagem() {
        String entrada = """
            9
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        MenuConsole menu = new MenuConsole(service);

        menu.run();
    }

    @Test
    void opcao3_deveAtualizarApenasOsCamposPreenchidos() {
        // A linha em branco no meio significa "manter a categoria atual"
        String entrada = """
            3
            123
            Buraco enorme na rua

            EM_ANDAMENTO
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        Ocorrencia existente = new Ocorrencia();
        existente.setId("123");
        existente.setDescricao("Buraco na rua");
        existente.setCategoria("BURACO");
        existente.setStatus("ABERTA");

        when(service.buscarPorId("123")).thenReturn(existente);

        MenuConsole menu = new MenuConsole(service);

        menu.run();

        ArgumentCaptor<Ocorrencia> captor = ArgumentCaptor.forClass(Ocorrencia.class);
        verify(service).atualizar(eq("123"), captor.capture());

        Ocorrencia atualizada = captor.getValue();
        assertEquals("Buraco enorme na rua", atualizada.getDescricao());
        assertEquals("BURACO", atualizada.getCategoria());
        assertEquals("EM_ANDAMENTO", atualizada.getStatus());
    }

    @Test
    void opcao3_naoDeveAtualizarQuandoIdNaoExiste() {
        String entrada = """
            3
            999
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        when(service.buscarPorId("999")).thenReturn(null);

        MenuConsole menu = new MenuConsole(service);

        menu.run();

        verify(service, never()).atualizar(anyString(), any(Ocorrencia.class));
    }

    @Test
    void opcao4_deveDeletarQuandoUsuarioConfirma() {
        String entrada = """
            4
            123
            S
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        Ocorrencia existente = new Ocorrencia();
        existente.setId("123");

        when(service.buscarPorId("123")).thenReturn(existente);

        MenuConsole menu = new MenuConsole(service);

        menu.run();

        verify(service).deletar("123");
    }

    @Test
    void opcao4_naoDeveDeletarQuandoUsuarioCancela() {
        String entrada = """
            4
            123
            N
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        Ocorrencia existente = new Ocorrencia();
        existente.setId("123");

        when(service.buscarPorId("123")).thenReturn(existente);

        MenuConsole menu = new MenuConsole(service);

        menu.run();

        verify(service, never()).deletar(anyString());
    }

    @Test
    void opcao4_naoDeveDeletarQuandoIdNaoExiste() {
        String entrada = """
            4
            999
            0
            """;

        System.setIn(new java.io.ByteArrayInputStream(entrada.getBytes()));

        when(service.buscarPorId("999")).thenReturn(null);

        MenuConsole menu = new MenuConsole(service);

        menu.run();

        verify(service, never()).deletar(anyString());
    }
}
