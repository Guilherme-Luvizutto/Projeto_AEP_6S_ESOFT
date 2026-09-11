package com.AEP.urbaniza.console;

import com.AEP.urbaniza.service.OcorrenciaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

}
