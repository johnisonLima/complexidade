package br.edu.ifba.minasaquaticas.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.minasaquaticas.sensoriamento.Sensoriamento;

public class SensoriamentoImpl implements Sensoriamento<Leitura> {

    // Profundidade: mina ancorada, mas sofre variação por correntes e marés
    private static final int PROFUNDIDADE_NORMAL = 20; 
    private static final int OCILACAO_MAXIMA_PROFUNDIDADE = 5; // pequena - mina ancorada 

    // Proximidade: varia mais, pois objetos se aproximam/afastam constantemente
    private static final int PROXIMIDADE_NORMAL = 20; 
    private static final int OCILACAO_MAXIMA_PROXIMIDADE = 20; 

    // O(N) — gera uma lista de leituras simuladas, cada leitura O(1)
    @Override
    public List<Leitura> obterDados(int quantidade) {
        List<Leitura> leituras = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            int profundidade = PROFUNDIDADE_NORMAL + random.nextInt(OCILACAO_MAXIMA_PROFUNDIDADE * 2 + 1) - OCILACAO_MAXIMA_PROFUNDIDADE;

            int proximidade = PROXIMIDADE_NORMAL + random.nextInt(OCILACAO_MAXIMA_PROXIMIDADE * 2 + 1) - OCILACAO_MAXIMA_PROXIMIDADE;

            Leitura leitura = new Leitura(profundidade, proximidade);
            leituras.add(leitura);
        }


        return leituras;

    }
    
}
