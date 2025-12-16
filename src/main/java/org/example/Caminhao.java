package org.example;

public class Caminhao extends Veiculo {
    public Caminhao(String marca, String cor, int ano) {
        super(marca, cor, ano);
    }


    public void acelerar() {
    }

    @Override
    public void emitirSom() {
        System.out.println("som de caminhão");

    }
}
