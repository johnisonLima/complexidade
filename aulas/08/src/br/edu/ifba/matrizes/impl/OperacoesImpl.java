package br.edu.ifba.matrizes.impl;

import br.edu.ifba.matrizes.operacoes.Operacoes;

public class OperacoesImpl implements Operacoes<Integer> {

    @Override
    public void imprimir(Integer[][] matriz) {

        // Complexidade quadratica, O(n^2) por que
        // dois loops aninhadoscom relação a matriz, onde n é o número de linhas ou colunas da matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Integer[][] multiplicar(Integer[][] matrizA, Integer[][] matrizB) {
        int tamanho = matrizA.length;
        Integer[][] resultante = new Integer[tamanho][tamanho];

        for(int i=0; i < tamanho; i++) {
            for(int j=0; j < tamanho; j++) {
                resultante[i][j] = 0;

                for(int k=0; k < tamanho; k++) {
                    resultante[i][j] += matrizA[i][k] * matrizB[k][j];
                }

                
            }
        }
        return resultante;
    }
}
