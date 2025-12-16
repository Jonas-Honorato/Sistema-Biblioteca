package praticar;

public class Livro {
    private String autor;
    private String titulo;
    private int ano;
    private boolean disponivel;

    public Livro(String autor, String titulo, int ano) {
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.disponivel = true;


    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestarLivro() {
        if (disponivel) {
            disponivel = false;
            System.out.println("O livro " + titulo + " foi emprestado com sucesso!");
        } else {
            System.out.println("O livro " + titulo + " já está emprestado!");
        }
    }

    public void devolverLivro() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("O livro " + titulo + " foi devolvido com sucesso!");
        } else {
            System.out.println("este livro já está disponível, não é possível devolver");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean emprestar() {
        if (!disponivel) return false;
        disponivel = false;
        return true;

    }
    public boolean devolver(){
        if (disponivel) return false; // já está disponível
        disponivel = true;
        return true;

    }
}
