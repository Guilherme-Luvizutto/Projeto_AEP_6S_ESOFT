package com.AEP.urbaniza.console;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.service.OcorrenciaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Profile("!test")
public class MenuConsole implements CommandLineRunner {

    private final OcorrenciaService service;
    private final Scanner scanner = new Scanner(System.in);

    public MenuConsole(OcorrenciaService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        while (true) {
            System.out.println("\n===== URBANIZA =====");
            System.out.println("1 - Cadastrar ocorrência");
            System.out.println("2 - Listar ocorrências");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                Ocorrencia ocorrencia = new Ocorrencia();

                System.out.print("Descrição: ");
                ocorrencia.setDescricao(scanner.nextLine());

                System.out.print("Categoria: ");
                ocorrencia.setCategoria(scanner.nextLine());

                System.out.print("Status: ");
                ocorrencia.setStatus(scanner.nextLine());

                service.criar(ocorrencia);

                System.out.println("Ocorrência cadastrada!");
            }

            else if (opcao.equals("2")) {
                System.out.println("\n===== OCORRÊNCIAS =====");

                for (Ocorrencia ocorrencia : service.listarTodos()) {
                    System.out.println("ID: " + ocorrencia.getId());
                    System.out.println("Descrição: " + ocorrencia.getDescricao());
                    System.out.println("Categoria: " + ocorrencia.getCategoria());
                    System.out.println("Status: " + ocorrencia.getStatus());
                    System.out.println("-----------------------");
                }
            }

            else if (opcao.equals("0")) {
                System.out.println("Encerrando Urbaniza...");
                break;
            }

            else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
