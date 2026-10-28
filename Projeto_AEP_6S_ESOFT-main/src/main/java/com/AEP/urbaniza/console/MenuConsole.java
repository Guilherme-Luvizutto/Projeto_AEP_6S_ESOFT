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
            System.out.println("3 - Atualizar ocorrência");
            System.out.println("4 - Deletar ocorrência");
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

            else if (opcao.equals("3")) {
                atualizarOcorrencia();
            }

            else if (opcao.equals("4")) {
                deletarOcorrencia();
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

    private void atualizarOcorrencia() {
        System.out.println("\n===== ATUALIZAR OCORRÊNCIA =====");
        System.out.print("ID da ocorrência: ");
        String id = scanner.nextLine().trim();

        Ocorrencia ocorrencia = buscarOuAvisar(id);
        if (ocorrencia == null) {
            return;
        }

        System.out.println("\nDados atuais:");
        exibir(ocorrencia);
        System.out.println("(Deixe em branco e pressione Enter para manter o valor atual)");

        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();
        if (!descricao.isBlank()) {
            ocorrencia.setDescricao(descricao);
        }

        System.out.print("Nova categoria: ");
        String categoria = scanner.nextLine();
        if (!categoria.isBlank()) {
            ocorrencia.setCategoria(categoria);
        }

        System.out.print("Novo status: ");
        String status = scanner.nextLine();
        if (!status.isBlank()) {
            ocorrencia.setStatus(status);
        }

        service.atualizar(id, ocorrencia);

        System.out.println("Ocorrência atualizada!");
    }

    private void deletarOcorrencia() {
        System.out.println("\n===== DELETAR OCORRÊNCIA =====");
        System.out.print("ID da ocorrência: ");
        String id = scanner.nextLine().trim();

        Ocorrencia ocorrencia = buscarOuAvisar(id);
        if (ocorrencia == null) {
            return;
        }

        exibir(ocorrencia);
        System.out.print("Tem certeza que deseja deletar? (S/N): ");
        String confirmacao = scanner.nextLine().trim();

        if (confirmacao.equalsIgnoreCase("S")) {
            service.deletar(id);
            System.out.println("Ocorrência deletada!");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private Ocorrencia buscarOuAvisar(String id) {
        if (id.isBlank()) {
            System.out.println("ID inválido!");
            return null;
        }

        Ocorrencia ocorrencia = service.buscarPorId(id);

        if (ocorrencia == null) {
            System.out.println("Ocorrência não encontrada!");
        }

        return ocorrencia;
    }

    private void exibir(Ocorrencia ocorrencia) {
        System.out.println("ID: " + ocorrencia.getId());
        System.out.println("Descrição: " + ocorrencia.getDescricao());
        System.out.println("Categoria: " + ocorrencia.getCategoria());
        System.out.println("Status: " + ocorrencia.getStatus());
        System.out.println("-----------------------");
    }
}




