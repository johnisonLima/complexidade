package br.edu.ifba.busca;

import br.edu.ifba.busca.buscador.Buscador;
import br.edu.ifba.busca.buscador.ResultadoBusca;
import br.edu.ifba.busca.impl.BuscaBinaria;
import br.edu.ifba.busca.impl.GeradorNumeros;
import br.edu.ifba.busca.numeros.Numeros;

public class App {
    public static void main(String[] args) throws Exception {
        Numeros gerador = new GeradorNumeros();
        Buscador buscador = new BuscaBinaria();

        int[] vetor = gerador.gerarVetor(10);
        int valor = 5;
        
        ResultadoBusca resultado = buscador.buscar(vetor, valor);

        System.out.println("Vetor: " + java.util.Arrays.toString(vetor));
        if (resultado == ResultadoBusca.ENCONTRADO) {
            System.out.println("Valor " + valor + " encontrado no vetor.");
        } else {
            System.out.println("Valor " + valor + " não encontrado no vetor.");
            
        }
    }
}

// Pior caso: o valor não está presente no vetor, o que resulta em O(log n) para a busca binária.
// Melhor caso: o valor está presente no meio do vetor, o que resulta em O(1) para a busca binária.
// Caso médio: o valor está presente nas extremidades do vetor, o que resulta em O(log n) para a busca binária.