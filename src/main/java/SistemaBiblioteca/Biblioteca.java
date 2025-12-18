package SistemaBiblioteca;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public boolean registrarLivro(Livro livro) {
        if (livros.contains(livro)) {
            return false;
        }
        livros.add(livro);
        return true;
    }

    public boolean registrarUsuario(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo))
                return livro;
        }
        return null;

    }

    public Usuario buscarUsuarioPorId(int usuarioId) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == usuarioId) {
                return usuario;
            }
        }
        return null;
    }

    public boolean emprestarLivro(String titulo, int usuarioId) {
        Usuario usuario = buscarUsuarioPorId(usuarioId);
        Livro livro = buscarLivroPorTitulo(titulo);

        if (usuario == null) {
            System.out.println("Usuário com ID: " + usuarioId + " não está registrado");
            return false;
        }
        if (livro == null) {
            System.out.println("O livro '" + titulo + "' não existe na sua biblioteca");
            return false;
        }

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().equals(livro) && emprestimo.isAtivo()) {
                System.out.println("Já existe um empréstimo ativo para este livro.");
                return false;
            }
        }

        if (livro.emprestar()) {
            Emprestimo novoEmprestimo = new Emprestimo(livro, usuario);
            emprestimos.add(novoEmprestimo);
            usuario.adicionarLivroEmprestado(livro);

            System.out.println("Livro '" + titulo + "' emprestado com sucesso para " + usuario.getNome() +
                    ". Devolução prevista: " + novoEmprestimo.getDataPrevistaDevolucao());
            return true;
        }

        return false;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public boolean devolverLivro(String titulo, Usuario usuario) {
        Livro livro = buscarLivroPorTitulo(titulo);

        if (livro == null) {
            System.out.println("O livro '" + titulo + "' não existe na sua biblioteca");
            return false;
        }

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().equals(livro) &&
                    emprestimo.getUsuario().equals(usuario) &&
                    emprestimo.isAtivo()) {

                emprestimo.finalizarEmprestimo();

                livro.devolver();

                usuario.removerLivroEmprestado(livro);

                if (emprestimo.getDataDevolucao().isAfter(emprestimo.getDataPrevistaDevolucao())) {
                    long diasAtraso = ChronoUnit.DAYS.between(
                            emprestimo.getDataPrevistaDevolucao(),
                            emprestimo.getDataDevolucao()
                    );
                    double multa = diasAtraso * 2.0;
                    usuario.adicionarMulta(multa);

                    System.out.println("Livro devolvido com atraso de " + diasAtraso +
                            " dias. Multa de R$ " + multa + " registrada para " +
                            usuario.getNome());
                } else {
                    System.out.println("Livro devolvido no prazo por " + usuario.getNome());
                }

                return true;
            }
        }

        System.out.println("Não existe empréstimo ativo para este livro/usuário.");
        return false;
    }

    public List<Livro> buscarPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo()) {
                ativos.add(emprestimo);
            }
        }
        return ativos;
    }

    public List<Emprestimo> listarEmprestimosPorUsuario(int usuarioId) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getId() == usuarioId) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }

    public List<Usuario> listarUsuariosComMulta() {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getMultaAcumulada() > 0) {
                resultado.add(usuario);
            }
        }
        return resultado;
    }

}
