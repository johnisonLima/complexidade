package br.edu.ifba.busca.impl;

import br.edu.ifba.busca.buscador.Buscador;
import br.edu.ifba.busca.buscador.ResultadoBusca;

public class BuscaBinaria implements Buscador{

    @Override
    public ResultadoBusca buscar(int[] vetor, int valor) {

        ResultadoBusca resultado = ResultadoBusca.NAO_ENCONTRADO;

        int fim = vetor.length - 1;

        if (valor <= vetor[fim]){
            
            int inicio = 0;
            int meio = 0;

            while (inicio <= fim) {
                meio = (inicio + fim) / 2;

                if (vetor[meio] < valor) {
                    inicio = meio + 1;
                } else if (vetor[meio] > valor) {
                    fim = meio - 1;
                } else {
                    resultado = ResultadoBusca.ENCONTRADO;
                    break;
                }
            }
        }

        return resultado;
    }
    
}
