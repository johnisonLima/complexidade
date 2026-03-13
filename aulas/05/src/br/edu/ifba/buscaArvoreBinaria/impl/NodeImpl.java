package br.edu.ifba.buscaArvoreBinaria.impl;

import br.edu.ifba.buscaArvoreBinaria.arvore.Node;

public class NodeImpl implements Node<Integer> {

    private Integer chave;
    private Node<Integer> esquerda;
    private Node<Integer> direita;

    public NodeImpl(Integer chave) {
        this.chave = chave;
        this.esquerda = null;
        this.direita = null;
    }

    @Override
    public Integer getChave() {
        return chave;
    }

    @Override
    public void setChave(Integer chave) {
        this.chave = chave;
    }

    @Override
    public Node<Integer> getEsquerda() {
        return esquerda;
    }

    @Override
    public void setEsquerda(Node<Integer> esquerda) {
        this.esquerda = esquerda;
    }

    @Override
    public Node<Integer> getDireita() {
        return direita;
    }

    @Override
    public void setDireita(Node<Integer> direita) {
        this.direita = direita;
    }
    
}
