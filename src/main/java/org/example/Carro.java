package org.example;

public class Carro extends Veiculo{

    public Carro(String marca,String cor, int ano) {
        super(marca,cor, ano);
    }

    public void acelerar(){
    }

    @Override
    public void emitirSom() {
        System.out.println("som de Carro");

    }
}
