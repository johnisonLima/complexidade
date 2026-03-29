package br.edu.ifba.bubblesort.impl;

import br.edu.ifba.bubblesort.ordenador.Ordenador;

public class Buddle implements Ordenador<Integer> {

    @Override
    public String getTipo() {
        return "Buddle Sort";
    }

    @Override
    public void ordenar(Integer[] vetor) {
        bubbleSort(vetor);
    }

    private void bubbleSort(Integer[] vetor) {
        int n = vetor.length;
        int temp;
        boolean trocado;

        for (int i = 0; i < n - 1; i++) {
            trocado = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;

                    trocado = true;
                }
            }

            if (!trocado) {
                break;
            }
        }
    }

}
