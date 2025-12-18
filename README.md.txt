# Sistema de Biblioteca (Estudo Pessoal)

Este projeto é um exercício de programação orientada a objetos em Java, criado apenas para **aprendizado e prática pessoal**.  
O objetivo foi implementar um sistema simples de gerenciamento de biblioteca com funcionalidades como empréstimo de livros, devolução, cálculo de multas e relatórios.

---

## 🚀 Tecnologias utilizadas

- **Java 17** → linguagem principal do projeto  
- **Paradigma Orientado a Objetos (POO)** → uso de classes, objetos, encapsulamento e herança  
- **Coleções (`List`)** → para armazenar livros, usuários e empréstimos  
- **API de Datas (`java.time.LocalDate`)** → para controlar prazos de empréstimos e devoluções  
- **JUnit 5** → para testes unitários das classes principais (`Livro`, `Usuario`, `Biblioteca`)  
- **Console (Scanner)** → interface textual simples para interação com o sistema  

---

## 📚 Funcionalidades implementadas

- Registro de usuários e livros  
- Empréstimo e devolução de livros  
- Cálculo de multa por atraso (R$ 2/dia)  
- Pagamento de multas  
- Relatórios e buscas:
  - Buscar livros por autor  
  - Listar livros disponíveis  
  - Listar empréstimos ativos  
  - Listar empréstimos por usuário  
  - Listar usuários com multa  

---

## 🧪 Testes

Os testes foram implementados com **JUnit 5** e cobrem:
- Classe `Livro`: empréstimo e devolução  
- Classe `Usuario`: controle de livros emprestados e multas  
- Classe `Biblioteca`: registro, empréstimos, devoluções e cálculo de multas  

Para rodar os testes:
```bash
mvn test