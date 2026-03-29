package br.edu.ifba.matrizes;

import br.edu.ifba.matrizes.impl.OperacoesImpl;
import br.edu.ifba.matrizes.operacoes.Operacoes;

public class App {
    public static void main(String[] args) throws Exception {
        Integer[][] matrizA = new Integer[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Integer[][] matrizB = new Integer[][] {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        Operacoes<Integer> operacoes = new OperacoesImpl();
        Integer[][] resultado = operacoes.multiplicar(matrizA, matrizB);
        operacoes.imprimir(resultado);

    }
}
