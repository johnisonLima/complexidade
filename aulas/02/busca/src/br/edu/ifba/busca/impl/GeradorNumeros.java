package br.edu.ifba.busca.impl;

import br.edu.ifba.busca.numeros.Numeros;

public class GeradorNumeros implements Numeros{

    @Override
    public int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i + 1;
        }

        return vetor;
    }
    
}
