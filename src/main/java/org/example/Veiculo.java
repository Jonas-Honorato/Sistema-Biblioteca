package org.example;

public abstract class Veiculo {
    private String marca;
    private String cor;
    private int ano;

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }

    public Veiculo(String marca, String cor, int ano) {
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
    }

    public void acelerar() {
        System.out.println("veiculo acelera...");
    }

    public abstract void emitirSom();


}
