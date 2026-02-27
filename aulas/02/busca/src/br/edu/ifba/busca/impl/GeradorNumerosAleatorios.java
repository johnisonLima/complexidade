package br.edu.ifba.busca.impl;

import java.util.Random;

import br.edu.ifba.busca.numeros.Numeros;

public class GeradorNumerosAleatorios implements Numeros{

    @Override
    public int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];

        Random randomizador = new Random();
        for (int i = 0; i < tamanho; i++) {
            int numero = randomizador.nextInt(1, tamanho * 3);

            vetor[i] = numero;
        }


        return vetor;
    }

    
}