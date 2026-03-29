package br.edu.ifba.ordenacao;

import br.edu.ifba.ordenacao.impl.Merge;
import br.edu.ifba.ordenacao.ordenador.Ordenador;

public class App {
    public static void main(String[] args) throws Exception {
        Ordenador<Integer> ordenador = new Merge();

        Integer[] vetor = new Integer[] {10, 1, -3, 20, 1000, 0};

        ordenador.ordenar(vetor);

        for (Integer numero: vetor) {
            System.out.println(numero);
        }
    }
}
