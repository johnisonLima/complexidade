package br.edu.ifba.busca;

import java.util.Arrays;

import br.edu.ifba.busca.buscador.Buscador;
import br.edu.ifba.busca.buscador.ResultadoBusca;
import br.edu.ifba.busca.impl.BuscaBinaria;
// import br.edu.ifba.busca.impl.GeradorNumeros;
import br.edu.ifba.busca.impl.GeradorNumerosAleatorios;
import br.edu.ifba.busca.numeros.Numeros;

public class App {
    private static final int TAMANHO_VETOR = 100;
    private static final double LIMIAR_MELHOR_CASO = (double) TAMANHO_VETOR * 0.05;
    public static void main(String[] args) throws Exception {
        // Numeros gerador = new GeradorNumeros();
        Numeros gerador = new GeradorNumerosAleatorios();
        Buscador buscador = new BuscaBinaria();

        int[] vetor = gerador.gerarVetor(TAMANHO_VETOR);
        int valor = 110;
        
        Arrays.sort(vetor);

        ResultadoBusca resultado = buscador.buscar(vetor, valor);
        int passos = buscador.getTotalPassos();

        // System.out.println("Vetor: " + java.util.Arrays.toString(vetor));
        if (resultado == ResultadoBusca.ENCONTRADO) {
            double limiarMelhorCaso = LIMIAR_MELHOR_CASO;
            

            System.out.println("Valor " + valor + " encontrado no vetor.");            
            
            if (passos <= limiarMelhorCaso) {
                System.out.println("Limiar do melhor caso: " + limiarMelhorCaso);
                System.out.println("O algoritmo está no melhor caso.");
            } else {
                System.out.println("O algoritmo está no pior caso.");
            }
        } else {
            System.out.println("Valor " + valor + " não encontrado no vetor.");
        }
        System.out.println("Total de passos: " + passos);
    }
}

// Pior caso: o valor não está presente no vetor, o que resulta em O(log n) para a busca binária.
// Melhor caso: o valor está presente no meio do vetor, o que resulta em O(1) para a busca binária.
// Caso médio: o valor está presente nas extremidades do vetor, o que resulta em O(log n) para a busca binária.
//              executa poucas partições do vetor até encontrar o valor ou determinar que ele não está presente, o que resulta em O(log n) para a busca binária.