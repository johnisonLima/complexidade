package br.edu.ifba.ordenacao.ordenador;

public interface Ordenador<T> {
    public String getTipo();

    public void ordenar(T[] vetor);

    
}
