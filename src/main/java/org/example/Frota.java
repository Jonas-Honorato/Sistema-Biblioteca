package org.example;

import java.util.ArrayList;

public class Frota {
    ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);


    }

    public void listarVeiculos() {
        System.out.println("\n===== LISTA DE VEÍCULOS =====");

        for (Veiculo veiculo : veiculos) {
            System.out.println("----------------------------");
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Ano: " + veiculo.getAno());
        }

        System.out.println("----------------------------\n");
    }
    public void removerVeiculos(Veiculo veiculo){
        veiculos.remove(veiculo);
    }

}


