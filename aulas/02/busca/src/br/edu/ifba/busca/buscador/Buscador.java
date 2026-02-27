package br.edu.ifba.busca.buscador;

public interface Buscador {

    ResultadoBusca buscar(int[] vetor, int numero);

    int getTotalPassos();
    
}
