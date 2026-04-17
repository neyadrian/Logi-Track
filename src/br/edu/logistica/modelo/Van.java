package br.edu.logistica.modelo;

import br.edu.logistica.modelo.enuns.TipoCombustivel;

public class Van extends Veiculo {
    private boolean possuiRefrigeracao;

    private static final int CAPACIDADE_TANQUE = 60;
    private static final double PENALIDADE_REFRIGERACAO = 0.15;

    public Van(String placa, double capacidadeCarga, TipoCombustivel tipoCombustivel, boolean possuiRefrigeracao) {
        super(placa, capacidadeCarga, tipoCombustivel);
        this.possuiRefrigeracao = possuiRefrigeracao;
    }


}
