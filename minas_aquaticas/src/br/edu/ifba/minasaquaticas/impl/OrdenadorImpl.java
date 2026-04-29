package br.edu.ifba.minasaquaticas.impl;

import java.util.List;

import br.edu.ifba.minasaquaticas.ordenador.Ordenador;
import br.edu.ifba.minasaquaticas.ordenador.TipoOrdenacao;

public class OrdenadorImpl extends Ordenador<Leitura> {

    public OrdenadorImpl(List<Leitura> leituras, TipoOrdenacao tipoOrdenacao) {
        super(leituras, tipoOrdenacao);
    }

    // O(N log N) — garante pior caso melhor que QuickSort
    @Override
    public void ordenar() {
        int n = leituras.size();

        // Fase 1: constrói o Max-Heap — O(N)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        // Fase 2: extrai elementos do heap um a um — O(N log N)
        for (int i = n - 1; i > 0; i--) {
            trocar(0, i);        // move raiz (maior) para o final
            heapify(i, 0);       // restaura o heap na parte restante
        }
    }

    // O(log N) — garante a propriedade do Max-Heap a partir do nó i
    private void heapify(int tamanhoHeap, int i) {
        int maior = i;
        int filhoEsquerdo = 2 * i + 1;
        int filhoDireito  = 2 * i + 2;

        if (filhoEsquerdo < tamanhoHeap && comparar(filhoEsquerdo, maior) > 0) {
            maior = filhoEsquerdo;
        }

        if (filhoDireito < tamanhoHeap && comparar(filhoDireito, maior) > 0) {
            maior = filhoDireito;
        }

        if (maior != i) {
            trocar(i, maior);
            heapify(tamanhoHeap, maior); // O(log N)
        }
    }

    // O(1) — centraliza a lógica de comparação por tipo
    private int comparar(int indexA, int indexB) {
        Leitura a = leituras.get(indexA);
        Leitura b = leituras.get(indexB);

        if (tipoOrdenacao == TipoOrdenacao.POR_PROFUNDIDADE) {
            return Integer.compare(a.getProfundidade(), b.getProfundidade());
        } else {
            return Integer.compare(a.getProximidade(), b.getProximidade());
        }
    }

    // O(1)
    private void trocar(int i, int j) {
        Leitura temp = leituras.get(i);
        leituras.set(i, leituras.get(j));
        leituras.set(j, temp);
    }
}