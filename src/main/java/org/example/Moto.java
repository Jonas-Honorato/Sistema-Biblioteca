package org.example;

public class Moto extends Veiculo{

    public Moto(String marca,String cor, int ano){
        super(marca ,cor, ano);
    }

    public void acelerar(){
    }

    @Override
    public void emitirSom() {
        System.out.println("Som de moto");

    }
}
