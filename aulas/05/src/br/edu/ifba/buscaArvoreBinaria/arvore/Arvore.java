package br.edu.ifba.buscaArvoreBinaria.arvore;

public abstract class Arvore<T> {

    private Node<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Node<T> getRaiz() {
        return raiz;
    }

    public abstract Node<T> inserir(Node <T> raiz, T chave);

    public abstract Node<T> buscar(Node <T> raiz, T chave);

    public void inserir(T chave) {
        this.raiz = inserir(this.raiz, chave);
    }

    public Node<T> buscar(T chave) {
        return buscar(this.raiz, chave);
    }

    public abstract void imprimir();
}
