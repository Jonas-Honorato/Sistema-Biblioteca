
        package praticar;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int id;
    private List<Livro> livrosEmprestados;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }

    public void pegarLivro(Livro livro) {
        if (!livro.isDisponivel()) {
            System.out.println("O livro não está disponivel");
            return;
        }
        livro.emprestarLivro();
        livrosEmprestados.add(livro);

    }

    public void devolverLivro(Livro livro) {
        if (!livrosEmprestados.contains(livro)) {
            System.out.println("O usuário não possui este livro, não é possível devolver.");
            return;
        }
        livro.devolverLivro();
        livrosEmprestados.remove(livro);

    }
    public void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }
    public void removerLivroEmprestado(Livro livro) {
        livrosEmprestados.remove(livro);
    }

    public String getNome(){
        return nome;
    }


    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public int getId() {
        return id;
    }
}
