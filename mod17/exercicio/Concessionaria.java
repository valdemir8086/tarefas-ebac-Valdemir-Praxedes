package br.com;

import br.com.carros.Carro;

import java.util.ArrayList;
import java.util.List;

public class Concessionaria<T extends Carro> {

    private List<T> carros;

    public Concessionaria() {
        carros = new ArrayList<T>();
    }

    public List<T> getCarros() {
        return carros;
    }

    public void addCarro(T carro){
        carros.add(carro);
    }
}
