package com.AEP.urbaniza.console;

import com.AEP.urbaniza.model.Ocorrencia;
import com.AEP.urbaniza.service.OcorrenciaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.AEP.urbaniza.model.Localizacao;
import com.AEP.urbaniza.service.UsuarioService;
import com.AEP.urbaniza.model.Usuario;

import java.util.Scanner;

@Component
@Profile("!test")
public class MenuConsole implements CommandLineRunner {

    private final OcorrenciaService service;
    private final UsuarioService usuarioService;
    private final Scanner scanner = new Scanner(System.in);

    public MenuConsole(OcorrenciaService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
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

                System.out.print("E-mail do usuário: ");
                String email = scanner.nextLine();

                Usuario usuario = usuarioService.buscarPorEmail(email);

                if (usuario == null) {
                    System.out.println("Usuário não encontrado! Verifique o e-mail.");
                    continue;
                }

                ocorrencia.setUsuarioId(usuario.getId());

                Localizacao localizacao = new Localizacao();

                System.out.print("Rua: ");
                localizacao.setRua(scanner.nextLine());

                System.out.print("Bairro: ");
                localizacao.setBairro(scanner.nextLine());

                System.out.print("Número: ");
                localizacao.setNumero(scanner.nextLine());

                System.out.print("Cidade: ");
                localizacao.setCidade(scanner.nextLine());

                ocorrencia.setLocalizacao(localizacao);

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
                    System.out.println("ID do usuário: " + ocorrencia.getUsuarioId());

                    if (ocorrencia.getLocalizacao() != null) {
                        System.out.println("Rua: " + ocorrencia.getLocalizacao().getRua());
                        System.out.println("Bairro: " + ocorrencia.getLocalizacao().getBairro());
                        System.out.println("Número: " + ocorrencia.getLocalizacao().getNumero());
                        System.out.println("Cidade: " + ocorrencia.getLocalizacao().getCidade());
                    }

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

        System.out.print("Novo e-mail do usuário (Enter para manter): ");
        String email = scanner.nextLine();
        
        if (!email.isBlank()) {
            Usuario usuario = usuarioService.buscarPorEmail(email);
        
            if (usuario == null) {
                System.out.println("Usuário não encontrado! Atualização cancelada.");
                return;
            }
        
            ocorrencia.setUsuarioId(usuario.getId());
        }

        Localizacao localizacao = ocorrencia.getLocalizacao();

        if (localizacao == null) {
            localizacao = new Localizacao();
        }
        
        System.out.print("Nova rua: ");
        String rua = scanner.nextLine();
        if (!rua.isBlank()) {
            localizacao.setRua(rua);
        }
        
        System.out.print("Novo bairro: ");
        String bairro = scanner.nextLine();
        if (!bairro.isBlank()) {
            localizacao.setBairro(bairro);
        }
        
        System.out.print("Novo número: ");
        String numero = scanner.nextLine();
        if (!numero.isBlank()) {
            localizacao.setNumero(numero);
        }
        
        System.out.print("Nova cidade: ");
        String cidade = scanner.nextLine();
        if (!cidade.isBlank()) {
            localizacao.setCidade(cidade);
        }
        
        ocorrencia.setLocalizacao(localizacao);

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
        System.out.println("ID do usuário: " + ocorrencia.getUsuarioId());

        if (ocorrencia.getLocalizacao() != null) {
            System.out.println("Rua: " + ocorrencia.getLocalizacao().getRua());
            System.out.println("Bairro: " + ocorrencia.getLocalizacao().getBairro());
            System.out.println("Número: " + ocorrencia.getLocalizacao().getNumero());
            System.out.println("Cidade: " + ocorrencia.getLocalizacao().getCidade());
        }

        System.out.println("-----------------------");
    }
}




