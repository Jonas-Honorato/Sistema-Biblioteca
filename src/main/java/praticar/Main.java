//package praticar;
//
//public class Main {
//    public static void main(String[] args) {
//
//        // Criando biblioteca
//        Biblioteca biblioteca = new Biblioteca();
//
//        // Criando usuários
//        Usuario u1 = new Usuario("Jonas", 123);
//
//        // Criando livros
//        Livro l1 = new Livro("James Clear", "Hábitos Atômicos", 2019);
//        Livro l2 = new Livro("J. K. Rowling", "Harry Potter", 1997);
//
//        // Adicionando livros na biblioteca
//        biblioteca.adicionarLivro(l1);
//        biblioteca.adicionarLivro(l2);
//
//        // --- Testes ---
//
//        // Jonas pega "Hábitos Atômicos"
//        biblioteca.pegarLivro(u1, l1);
//
//        // Tenta pegar o mesmo livro de novo
//        biblioteca.pegarLivro(u1, l1);
//
//        // Jonas devolve o livro
//        biblioteca.devolverLivro(u1, l1);
//
//        // Tenta devolver novamente
//        biblioteca.devolverLivro(u1, l1);
//
//        // Pega outro livro
//        biblioteca.pegarLivro(u1, l2);
//
//        // Exibe livros emprestados do usuário
//        biblioteca.listarLivrosEmprestados(u1);
//    }
//}
