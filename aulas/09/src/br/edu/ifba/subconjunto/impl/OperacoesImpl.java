package br.edu.ifba.subconjunto.impl;

import java.util.Random;

import br.edu.ifba.subconjunto.operacoes.Operacoes;

public class OperacoesImpl implements Operacoes<Integer> {

    @Override
    public Integer[] gerarNumeros(int totalNumeros) {
        Integer[] vetor = new Integer[totalNumeros];

        Random random = new Random();

        for (int i = 0; i < totalNumeros; i++) {
            vetor[i] = random.nextInt(); 
        }
        return vetor;
    }
    
    @Override
    public boolean encontrar(Integer[] vetor, Integer soma) {
        return encontrar(vetor, soma, 0);
    }
    
    private boolean encontrar(Integer[] vetor, Integer soma, int index) {
        if (soma == 0) {
            return true;
        }

        if (index == vetor.length) {
            return false;
        }

        
        return encontrar(vetor, soma - vetor[index], index + 1) || encontrar(vetor, soma, index + 1);
    }
}
