package br.edu.ifba.nobreaks.clientes.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.edu.ifba.nobreaks.clientes.comunicacao.Cliente;
import br.edu.ifba.nobreaks.clientes.comunicacao.Resultado;
import br.edu.ifba.nobreaks.clientes.sensoriamento.Sensoriamento;

public class ClienteImpl implements Cliente<NoBreak, Leitura>, Runnable {

    private static final int TOTAL_DE_LEITURAS = 1000;

    private static final String URL_SERVIDOR = "http://172.12.172.111:8080";
    private static final String URL_NOBREAKS = URL_SERVIDOR + "/nobreaks/";

    private NoBreak noBreak = null;
    private Sensoriamento<Leitura> sensoriamento = null;

    private static final int LIMIAR_ENVIO_CARGA_BATERIA = 5;
    private static final int LIMIAR_ENVIO_TEMPERATURA = 5;

    private Leitura ultimaLeitura = new Leitura(0, 0);

    @Override
    public void configurar(NoBreak noBreak, Sensoriamento<Leitura> sensoriamento) {
        this.noBreak = noBreak;
        this.sensoriamento = sensoriamento;
    }

    @SuppressWarnings("deprecation")
    @Override
    public Resultado enviar(Leitura leitura) throws Exception {
        Resultado resultado = Resultado.SUCESSO;

        URL urlEnvio = new URL(URL_NOBREAKS + noBreak.getIdentificacao() + "/" + leitura.getTemperatura() + "/" + leitura.getCargaBateria());

        HttpURLConnection conexao = (HttpURLConnection) urlEnvio.openConnection();
        conexao.setRequestMethod("POST");
        if (conexao.getResponseCode() != 200) {
            resultado = Resultado.ERRO;

            throw new Exception("erro de conexão com o servidor");
        }
        conexao.disconnect();

        return resultado;
    }

    @Override
    public void run() {
        List<Leitura> leituras = sensoriamento.gerar(TOTAL_DE_LEITURAS);

        for (Leitura leitura: leituras) {
            int diferencaTemperatura = Math.abs(leitura.getTemperatura() - ultimaLeitura.getTemperatura());
            int diferencaCarga = Math.abs(leitura.getCargaBateria() - ultimaLeitura.getCargaBateria());

            if (diferencaCarga > LIMIAR_ENVIO_CARGA_BATERIA || diferencaTemperatura > LIMIAR_ENVIO_TEMPERATURA) {
                ultimaLeitura = leitura;

                System.out.println("leitura sendo enviada...");

                try {
                    enviar(leitura);

                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("não ocorreram diferenças significativas desde a última leitura");
            }
        }
    }
    
}
