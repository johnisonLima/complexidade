package br.edu.ifba.subconjunto;

import br.edu.ifba.subconjunto.impl.OperacoesImpl;
import br.edu.ifba.subconjunto.operacoes.Operacoes;

public class App {
    public static void main(String[] args) throws Exception {
        Operacoes<Integer> operacoes = new OperacoesImpl();

        Integer[] vetor = operacoes.gerarNumeros(100);

        if (operacoes.encontrar(vetor, 20)) {
            System.out.println("Soma encontrada!");
        } else {
            System.out.println("Soma não encontrada.");
        }
    }
}
