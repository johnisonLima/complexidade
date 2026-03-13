package br.edu.ifba.buscaArvoreBinaria;

import br.edu.ifba.buscaArvoreBinaria.arvore.Arvore;
import br.edu.ifba.buscaArvoreBinaria.arvore.Node;
import br.edu.ifba.buscaArvoreBinaria.impl.ArvoreImpl;

public class App {
    public static void main(String[] args) throws Exception {
        Arvore<Integer> arvore = new ArvoreImpl();

        int[] chaves = {80, 30, 20, 40, 70, 60, 90};

        for (int chave : chaves) {
            arvore.inserir(chave);
        }

        arvore.imprimir();
        Node<Integer> node = arvore.buscar(60);

        if(node != null){
            System.out.println("Valor encontrado: " + node.getChave());
        }
        else{
            System.out.println("Valor não encontrado na árvore.");
        }
    }

    // Pior caso: O(log n) quando o valor procurado não está presente na árvore ou está todo a direita ou todo a esquerda.
    // Melhor caso: O valor está presente nos primeiros nós raízes da árvore:
    // Caso méidio: a chave está na árvora, mas não é encontrada nos primeiros nós, ou seja, a chave está presente na árvore, mas não é encontrada nos primeiros nós.
}
