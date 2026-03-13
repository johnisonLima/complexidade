package br.edu.ifba.buscaArvoreBinaria.impl;

import br.edu.ifba.buscaArvoreBinaria.arvore.Arvore;
import br.edu.ifba.buscaArvoreBinaria.arvore.Node;

public class ArvoreImpl extends Arvore<Integer> {

    @Override
    public Node<Integer> inserir(Node<Integer> node, Integer chave) {
        if (node == null) {
            node = new NodeImpl(chave);

            return node;
        }

        if(chave < node.getChave()){
            node.setEsquerda(inserir(node.getEsquerda(), chave));
        }
        else if(chave > node.getChave()){
            node.setDireita(inserir(node.getDireita(), chave));
        }

        return node;
    }

    @Override
    public Node<Integer> buscar(Node<Integer> node, Integer chave) {
        if(node == null || node.getChave().equals(chave)){
            return node;
        }

        if(chave < node.getChave()){
            return buscar(node.getEsquerda(), chave);
        }
        else{
            return buscar(node.getDireita(), chave);
        }
    } 

    @Override
    public void imprimir() {
        StringBuilder stringBuilder = new StringBuilder();
        criarVisualizacao(stringBuilder, "", "", getRaiz());

        System.out.print(stringBuilder.toString());
    }

    public void criarVisualizacao(StringBuilder visualizador, String deslocamento, String apontador, Node<Integer> node) {
        if (node != null) {
            visualizador.append(deslocamento);
            visualizador.append(apontador);
            visualizador.append(node.getChave());
            visualizador.append("\n");

            StringBuilder visualizacaoApontador = new StringBuilder(deslocamento);
            visualizacaoApontador.append("│ ");

            String paraOsDoisLados = visualizacaoApontador.toString();
            String paraDireita = "└─D─";
            String paraEsquerda = (node.getDireita() != null) ? "├─E─" : "└─E─";

            criarVisualizacao(visualizador, paraOsDoisLados, paraEsquerda, node.getEsquerda());
            criarVisualizacao(visualizador, paraOsDoisLados, paraDireita, node.getDireita());
        }
    }


    
}