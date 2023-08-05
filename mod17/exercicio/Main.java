package br.com;

import br.com.carros.BMW;
import br.com.carros.Brasilia;
import br.com.carros.Carro;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Concessionaria<Carro> concessionaria = new Concessionaria();

        Carro carroBMW = new BMW(2023, "Vermelho");
        Carro carroBrasilia = new Brasilia(2020, "amarela");

        concessionaria.addCarro(carroBMW);
        concessionaria.addCarro(carroBrasilia);

        System.out.println("Todos os carros por Marca, modelo e ano na concessionária");

        for(Carro carro: concessionaria.getCarros()) {
                System.out.println("----------------------");
                System.out.println("Marca: "+carro.getMarca());
                System.out.println("modelo: "+carro.getModelo());
                System.out.println("ano: "+carro.getAno());
            }

        }
}