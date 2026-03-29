package br.edu.ifba.bubblesort;

import br.edu.ifba.bubblesort.ordenador.Ordenador;
import br.edu.ifba.bubblesort.impl.Buddle;

public class App {
    public static void main(String[] args) throws Exception {
        Ordenador<Integer> ordenador = new Buddle();

        Integer[] vetor = new Integer[] {10, 1, -3, 20, 1000, 0};

        ordenador.ordenar(vetor);

        for (Integer numero: vetor) {
            System.out.println(numero);
        }
    }
}
