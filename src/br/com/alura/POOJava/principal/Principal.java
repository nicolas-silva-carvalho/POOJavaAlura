import br.com.alura.POOJava.calculos.CalculadoraDeTempo;
import br.com.alura.POOJava.modelos.Filme;
import br.com.alura.POOJava.modelos.Serie;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Filme filme = new Filme();
        Serie serie = new Serie();
        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        filme.setDuracaoEmMinutos(190);
        calculadoraDeTempo.incluir(filme);
        System.out.println(calculadoraDeTempo.getTempoTotal());
        List<Filme> list = new LinkedList<>();
        list.add(filme);
        System.out.println(list);
    }
}
