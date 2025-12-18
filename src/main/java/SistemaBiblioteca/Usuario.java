package semIA;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private List<Livro> livrosEmprestados;
    private double multaAcumulada;

    public Usuario(String nome, int id) {
        this.id = id;
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
        this.multaAcumulada = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public double getMultaAcumulada() {
        return multaAcumulada;
    }

    // Adiciona multa (usado na devolução atrasada)
    public void adicionarMulta(double valor) {
        multaAcumulada += valor;
    }

    // Paga multa (usado quando o usuário quita a dívida)
    public void pagarMulta(double valor) {
        if (valor <= multaAcumulada) {
            multaAcumulada -= valor;
        } else {
            multaAcumulada = 0.0;
        }
    }

    public void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public void removerLivroEmprestado(Livro livro) {
        livrosEmprestados.remove(livro);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", multaAcumulada=" + multaAcumulada +
                '}';
    }
}