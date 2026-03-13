package br.edu.ifba.buscaArvoreBinaria.arvore;

public interface Node<T> {
    public T getChave();

    public void setChave(T chave);

    public Node<T> getEsquerda();

    public void setEsquerda(Node<T> esquerda);

    public Node<T> getDireita();

    public void setDireita(Node<T> direita);
}
