package br.edu.ifba.subconjunto.operacoes;

public interface Operacoes<T> {

    public T[] gerarNumeros(int totalNumeros);

    public boolean encontrar(T[] vetor, T soma);

}