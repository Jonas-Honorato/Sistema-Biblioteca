package semIA;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(7); // prazo padrão de 7 dias
        this.ativo = true;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    // Finaliza o empréstimo
    public void finalizarEmprestimo() {
        this.dataDevolucao = LocalDate.now();
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "📚 Empréstimo {" +
                "Livro='" + livro.getTitulo() + '\'' +
                ", Autor='" + livro.getAutor() + '\'' +
                ", Usuário='" + usuario.getNome() + '\'' +
                ", Data Empréstimo=" + dataEmprestimo +
                ", Prevista=" + dataPrevistaDevolucao +
                ", Devolução=" + (dataDevolucao != null ? dataDevolucao : "Ainda não devolvido") +
                ", Ativo=" + ativo +
                '}';
    }
}