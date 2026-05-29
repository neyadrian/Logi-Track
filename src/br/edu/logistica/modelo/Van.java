package br.edu.logistica.modelo;

import br.edu.logistica.modelo.enuns.TipoCombustivel;

/** * Classe que representa uma Van. *
 * PADRÕES SOLID APLICADOS: * - SOLID (SRP - Single Responsibility Principle): Responsável APENAS por *   calcular autonomia de vans com suas penalidades específicas. */

public class Van extends Veiculo {
    private boolean possuiRefrigeracao;

    private static final int CAPACIDADE_TANQUE = 60;
    private static final double PENALIDADE_REFRIGERACAO = 0.15;

    public Van(String placa, double capacidadeCarga, TipoCombustivel tipoCombustivel, boolean possuiRefrigeracao) {
        super(placa, capacidadeCarga, tipoCombustivel);
        this.possuiRefrigeracao = possuiRefrigeracao;
    }

    /**     * SRP: Calcula autonomia de forma específica para vans.     * Considera penalidade por refrigeração.     */
    @Override
    public double calcularAutonomia() {
        double fator = getTipoCombustivel().getFator();
        double multiplicador;

        if (possuiRefrigeracao) {
            multiplicador = 1.0 - PENALIDADE_REFRIGERACAO;
        } else {
            multiplicador = 1.0;
        }

        return CAPACIDADE_TANQUE * fator * multiplicador;
    }

    public final boolean isPossuiRefrigeracao() {
        return possuiRefrigeracao;
    }
}
