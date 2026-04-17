package br.edu.logistica.modelo;

import br.edu.logistica.modelo.enuns.TipoCombustivel;

public class Caminhao extends Veiculo{
    private int eixos;

    private static final int CAPACIDADE_TANQUE = 400;

    public Caminhao(String placa, double capacidadeCarga, TipoCombustivel combustivel, int eixos) {
        super(placa, capacidadeCarga, combustivel);
        this.eixos = eixos;
    }

    public double calcularAutonomia() {

    }
}
