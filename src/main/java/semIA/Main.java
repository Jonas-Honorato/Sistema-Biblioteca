package semIA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== MENU BIBLIOTECA ===");
            System.out.println("1 - Registrar usuário");
            System.out.println("2 - Registrar livro");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Listar empréstimos ativos");
            System.out.println("6 - Listar histórico de empréstimos");
            System.out.println("7 - Buscar livros por autor");
            System.out.println("8 - Listar livros disponíveis");
            System.out.println("9 - Listar empréstimos por usuário");
            System.out.println("10 - Listar usuários com multa");
            System.out.println("11 - Pagar multa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    biblioteca.registrarUsuario(new Usuario(nomeUsuario, idUsuario));
                    System.out.println("Usuário registrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autorLivro = scanner.nextLine();
                    biblioteca.registrarLivro(new Livro(tituloLivro, autorLivro));
                    System.out.println("Livro registrado com sucesso!");
                    break;

                case 3:
                    System.out.print("Título do livro: ");
                    String tituloEmprestimo = scanner.nextLine();
                    System.out.print("ID do usuário: ");
                    int idUsuarioEmprestimo = scanner.nextInt();
                    biblioteca.emprestarLivro(tituloEmprestimo, idUsuarioEmprestimo);
                    break;

                case 4:
                    System.out.print("Título do livro: ");
                    String tituloDevolucao = scanner.nextLine();
                    System.out.print("ID do usuário: ");
                    int idUsuarioDevolucao = scanner.nextInt();
                    Usuario usuarioDevolucao = biblioteca.buscarUsuarioPorId(idUsuarioDevolucao);
                    biblioteca.devolverLivro(tituloDevolucao, usuarioDevolucao);
                    break;

                case 5:
                    System.out.println("\n--- Empréstimos Ativos ---");
                    for (Emprestimo e : biblioteca.listarEmprestimosAtivos()) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    System.out.println("\n--- Histórico de Empréstimos ---");
                    for (Emprestimo e : biblioteca.getEmprestimos()) {
                        System.out.println(e);
                    }
                    break;

                case 7:
                    System.out.print("Autor: ");
                    String autorBusca = scanner.nextLine();
                    System.out.println("\n--- Livros de " + autorBusca + " ---");
                    for (Livro l : biblioteca.buscarPorAutor(autorBusca)) {
                        System.out.println(l);
                    }
                    break;

                case 8:
                    System.out.println("\n--- Livros Disponíveis ---");
                    for (Livro l : biblioteca.listarLivrosDisponiveis()) {
                        System.out.println(l);
                    }
                    break;

                case 9:
                    System.out.print("ID do usuário: ");
                    int idUsuarioConsulta = scanner.nextInt();
                    System.out.println("\n--- Empréstimos do usuário ---");
                    for (Emprestimo e : biblioteca.listarEmprestimosPorUsuario(idUsuarioConsulta)) {
                        System.out.println(e);
                    }
                    break;

                case 10:
                    System.out.println("\n--- Usuários com multa ---");
                    for (Usuario u : biblioteca.listarUsuariosComMulta()) {
                        System.out.println(u);
                    }
                    break;

                case 11:
                    System.out.print("ID do usuário: ");
                    int idUsuarioMulta = scanner.nextInt();
                    Usuario usuarioMulta = biblioteca.buscarUsuarioPorId(idUsuarioMulta);
                    System.out.print("Valor a pagar: ");
                    double valor = scanner.nextDouble();
                    usuarioMulta.pagarMulta(valor);
                    System.out.println("Multa restante: R$ " + usuarioMulta.getMultaAcumulada());
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}