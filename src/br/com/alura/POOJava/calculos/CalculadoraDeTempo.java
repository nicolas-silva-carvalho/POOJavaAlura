package br.com.alura.POOJava.calculos;

import br.com.alura.POOJava.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void incluir(Titulo titulo){
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
