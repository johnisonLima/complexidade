package br.edu.ifba.matrizes.operacoes;

public interface Operacoes<T> {

    public void imprimir(T[][] matriz);

    public T[][] multiplicar(T[][] matrizA, T[][] matrizB);

    
}
