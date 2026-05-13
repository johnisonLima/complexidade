package br.edu.ifba.nobreaks.servidor.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import br.edu.ifba.nobreaks.servidor.operacoes.Operacoes;

public class OperacoesImpl implements Operacoes<NoBreak, Leitura> {

    private static final int LIMIAR_ROTACIONAMENTO_LEITURAS = 40;

    private Map<NoBreak, Queue<Leitura>> bancoDeDados = new TreeMap<>();

    @Override
    public void gravar(NoBreak noBreak, Leitura leitura) {
        Queue<Leitura> leituras = new LinkedList<>();
        if (bancoDeDados.containsKey(noBreak)) {
            leituras = bancoDeDados.get(noBreak);
        } else {
            bancoDeDados.put(noBreak, leituras);
        }

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(leituras.size() >= LIMIAR_ROTACIONAMENTO_LEITURAS) {
            leituras.poll();
            
            System.out.println("rotacionada leitura mais antiga para o noBreak: " + noBreak);
        }

        leituras.add(leitura);

        System.out.println("gravada nova leitura para o noBreak: " + noBreak);
    }

    @Override
    public int detectarAltasOscilacoes(int limiarOscilacaoTemperatura,
            int limiarOscilacaoCargaBateria) {
        int contador = 0;

        // M 
        for (NoBreak noBreak: bancoDeDados.keySet()) {
            List<Leitura> leiturasPorNoBreak = new ArrayList<>(bancoDeDados.get(noBreak));
            int n = leiturasPorNoBreak.size();

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // N^2
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int oscilacaoTemperatura = Math.abs(leiturasPorNoBreak.get(i).getTemperatura() - leiturasPorNoBreak.get(j).getTemperatura());
                    int oscilacaoBateria = Math.abs(leiturasPorNoBreak.get(i).getCargaBateria() - leiturasPorNoBreak.get(j).getCargaBateria());

                    if (oscilacaoBateria > limiarOscilacaoCargaBateria || oscilacaoTemperatura > limiarOscilacaoTemperatura) {
                        contador++;
                    }
                }
            }
        }

        return contador;
    }
    
}
