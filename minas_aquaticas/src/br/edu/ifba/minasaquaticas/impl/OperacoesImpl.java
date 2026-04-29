package br.edu.ifba.minasaquaticas.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.minasaquaticas.operacoes.Operacoes;
import br.edu.ifba.minasaquaticas.ordenador.Ordenador;
import br.edu.ifba.minasaquaticas.ordenador.TipoOrdenacao;

public class OperacoesImpl implements Operacoes<Mina, Leitura> {

    // O(N)
    @Override
    public void imprimirMonitorado(List<Mina> monitorado) {
        for (Mina mina : monitorado) {
            System.out.println(mina);
        }
    }

    // O(N*M)
    @Override
    public void imprimir(Map<Mina, List<Leitura>> leituras) {
        for (Mina mina : leituras.keySet()) {
            System.out.println("Monitoramento " + mina);
            for (Leitura leitura : leituras.get(mina)) {
                System.out.println(leitura);
            }   
            System.out.println();
        }
    }

    // O(N*M log M) — N minas, M leituras por mina, ordenação O(M log M)
    @Override
    public Map<Mina, List<Leitura>> ordenar(Map<Mina, List<Leitura>> leiturasPorMinas, TipoOrdenacao tipoOrdenacao) {
        Map<Mina, List<Leitura>> leiturasOrdenadas = new TreeMap<>();

        for (Mina mina : leiturasPorMinas.keySet()) {
            
            List<Leitura> leiturasMina = leiturasPorMinas.get(mina);
            Ordenador<Leitura> ordenador = new OrdenadorImpl(leiturasMina, tipoOrdenacao);
            ordenador.ordenar();
            leiturasOrdenadas.put(mina, ordenador.getLeituras());
        }
        return leiturasOrdenadas;
    }

    // O(N^2 * M) — Para cada par de minas, verifica se um objeto
    // transitou entre elas com base em leituras críticas simultâneas
    @Override
    public int detectarObjetoEmTransito(Map<Mina, List<Leitura>> leiturasPorMinas, int limiteProximidadeCritica) {
        int contador = 0;

        List<Mina> minas = new ArrayList<>(leiturasPorMinas.keySet());
        int n = minas.size();

        // O(N^2) — para cada par de minas
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                Mina minaA = minas.get(i);
                Mina minaB = minas.get(j);

                List<Leitura> leiturasA = leiturasPorMinas.get(minaA);
                List<Leitura> leiturasB = leiturasPorMinas.get(minaB);

                int m = Math.min(leiturasA.size(), leiturasB.size());

                // O(M) — compara leituras no mesmo instante (mesmo índice = mesmo momento)
                for (int k = 0; k < m; k++) {
                    boolean alertaA = leiturasA.get(k).getProximidade() < limiteProximidadeCritica;
                    boolean alertaB = leiturasB.get(k).getProximidade() < limiteProximidadeCritica;

                    // Ambas detectaram algo próximo no mesmo instante → objeto em trânsito
                    if (alertaA && alertaB) {
                        contador++;
                        System.out.println("Objeto em trânsito detectado entre as minas ID=" + minaA.getId() + " e ID=" + minaB.getId() + " na leitura " + (k+1));
                    }
                }
            }
        }

        return contador;
    }

}
