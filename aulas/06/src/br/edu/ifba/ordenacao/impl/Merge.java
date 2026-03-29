package br.edu.ifba.ordenacao.impl;

import br.edu.ifba.ordenacao.ordenador.Ordenador;


public class Merge implements Ordenador<Integer> {

    @Override
    public String getTipo() {
        return "Merge Sort";
    }

    // A complexidade desse método e O(N log N)
    @Override
    public void ordenar(Integer[] vetor) {
        ordenar(vetor, vetor.length);
    }

    // A complexidade desse método é O(log N)
    private void ordenar(Integer[] vetor, Integer tamanho) {
        if (tamanho < 2) {
            return;
        }

        int meio = tamanho / 2;

        Integer[] novo_vetor_1 = new Integer[meio];
        Integer[] novo_vetor_2 = new Integer[tamanho - meio];

        for (int i = 0; i < meio; i++) {
            novo_vetor_1[i] = vetor[i];
        }

        for (int i = meio; i < tamanho; i++) {
            novo_vetor_2[i - meio] = vetor[i];
        }

        ordenar(novo_vetor_1, meio);
        ordenar(novo_vetor_2, tamanho - meio);

        juntar(vetor, novo_vetor_1, novo_vetor_2, meio, tamanho - meio);
    }
    // A complexidade desse metodo é O(N)
    private void juntar(Integer[] vetor, Integer[] novo_vetor_1, Integer[] novo_vetor_2, int esquerda, int direita) {
        int i = 0, j = 0, k = 0;

        while (i < esquerda && j < direita) {

            if (novo_vetor_1[i] <= novo_vetor_2[j]) {
                vetor[k++] = novo_vetor_1[i++];
            } else {
                vetor[k++] = novo_vetor_2[j++];
            }
        }

        while (i < esquerda) {
            vetor[k++] = novo_vetor_1[i++];
        }

        while (j < direita) {
            vetor[k++] = novo_vetor_2[j++];
        }
    }

}
