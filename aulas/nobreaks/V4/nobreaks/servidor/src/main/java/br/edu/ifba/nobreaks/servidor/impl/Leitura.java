package br.edu.ifba.nobreaks.servidor.impl;

public class Leitura {

    private Integer temperatura = 0;
    private Integer cargaBateria = 0;
    private Integer oscilacoes = 0;

    // O(1)
    public Leitura(Integer temperatura, Integer cargaBateria, Integer oscilacoes) {
        this.temperatura = temperatura;
        this.cargaBateria = cargaBateria;
        this.oscilacoes = oscilacoes;
    }
    
    // O(1)
    public Integer getOscilacoes() {
        return oscilacoes;
    }

    // O(1)
    public void setOscilacoes(Integer oscilacoes) {
        this.oscilacoes = oscilacoes;
    }

    // O(1)
    public Integer getTemperatura() {
        return temperatura;
    }

    // O(1)
    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    // O(1)
    public Integer getCargaBateria() {
        return cargaBateria;
    }

    // O(1)
    public void setCargaBateria(Integer cargaBateria) {
        this.cargaBateria = cargaBateria;
    }

    // O(1)
    @Override
    public String toString() {
        return "temperatura: " + temperatura + ", carga bateria: " + cargaBateria + ", oscilacoes: " + oscilacoes;
    }

}
