package br.edu.ifba.nobreaks.servidor.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.nobreaks.servidor.operacoes.Operacoes;

public class OperacoesImpl implements Operacoes<Nobreak, Leitura> {

    private Map<Nobreak, List<Leitura>> bancoDeDados = new TreeMap<>();

    @Override
    public void gravar(Nobreak noBreak, Leitura leitura) {
        List<Leitura> leituras = new ArrayList<>();

        if (bancoDeDados.containsKey(noBreak)) {
            leituras = bancoDeDados.get(noBreak);
        }
        else {
            bancoDeDados.put(noBreak, leituras);
        }

        leituras.add(leitura);

        System.out.println("Leitura gravada com sucesso para o nobreak: " + noBreak);
    }

    // O(N*M^2)
    @Override
    public int detectarAltasTemperaturas(int limiteOscilacaoTemperatura, int limiteOscilacaoCargaBateria) {
        int contador = 0;

        for (Nobreak nobreak : bancoDeDados.keySet()) {
            List<Leitura> leituras = bancoDeDados.get(nobreak);
            int n = leituras.size();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    int oscilacaoTemperatura = Math.abs(leituras.get(i).getTemperatura() -
                            leituras.get(j).getTemperatura());
                    int oscilacaoCargaBateria = Math
                            .abs(leituras.get(i).getCargaBateria() - leituras.get(j).getCargaBateria());

                    if (oscilacaoTemperatura > limiteOscilacaoTemperatura
                            || oscilacaoCargaBateria > limiteOscilacaoCargaBateria) {
                        contador++;
                    }
                }
            }
        }

        return contador;
    }
}
