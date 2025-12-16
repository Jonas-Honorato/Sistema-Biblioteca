        package praticar;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public boolean registrarLivro(Livro livro) {
        if (livros.contains(livro)) {
            return false;
        }
        livros.add(livro);
        return true;
    }

    public boolean registrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                return false;
            }

        }
        usuarios.add(usuario);
        return true;
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public boolean emprestarLivro(String titulo, Usuario usuario) {
        Livro livro = buscarLivroPorTitulo(titulo);
        if (livro == null) {
            System.out.println("Livro nao encontrado");
            return false;
        }
        if (!livro.isDisponivel()) {
            System.out.println("Livro já emprestado");
            return false;
        }
        if (livro.emprestar()) {
            usuario.adicionarLivroEmprestado(livro);
            System.out.println("Livro emprestado com sucesso para " + usuario.getNome());
            return true;
        }
        return false;

    }

    public boolean devolverlivro(String titulo, Usuario usuario) {
        Livro livro = buscarLivroPorTitulo(titulo);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return false;
        }

        if (!usuario.getLivrosEmprestados().contains(livro)) {
            System.out.println("Usuário não possui este livro emprestado.");
            return false;
        }

        if (livro.devolver()) {
            usuario.removerLivroEmprestado(livro);
            System.out.println("Livro devolvido com sucesso por " + usuario.getNome());
            return true;
        }

        return false;
    }
}





