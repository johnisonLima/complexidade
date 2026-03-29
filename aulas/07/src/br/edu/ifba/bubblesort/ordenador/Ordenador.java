package br.edu.ifba.bubblesort.ordenador;

public interface Ordenador<T> {
    public String getTipo();

    public void ordenar(T[] vetor);

    
}
