package br.edu.logistica.modelo;

import br.edu.logistica.modelo.enuns.TipoCombustivel;

/** * Classe que representa um Caminhão. *
 * PADRÕES SOLID APLICADOS: * - SOLID (SRP - Single Responsibility Principle): Responsável APENAS por *   calcular autonomia de caminhões com suas penalidades específicas. * - Implementa interface Monitoravel para rastreamento via satélite. */

public class Caminhao extends Veiculo implements Monitoravel {
    private int eixos;

    private static final double KM_POR_LITRO_BASE = 4.5;
    private static final int CAPACIDADE_TANQUE = 400;

    public Caminhao(String placa, double capacidadeCarga, TipoCombustivel combustivel, int eixos) {
        super(placa, capacidadeCarga, combustivel);
        this.eixos = eixos;
    }

    /**     * SRP: Calcula autonomia de forma específica para caminhões.     * Considera penalidades por eixos e carga.     */
    @Override
    public double calcularAutonomia() {
        double fator = getTipoCombustivel().getFator();
        double penEixos = 1.0 - (Math.max(0, eixos - 2) * 0.08);
        double penCarga = 1.0 - (Math.max(0, getCapacidadeCarga() - 10.0) / 5.0 * 0.05);
        return CAPACIDADE_TANQUE * fator * penEixos * penCarga;
    }

    @Override
    public void enviarCoordenadas() {
        System.out.println("Coordenadas enviadas via Satélite = Caminhão " + getPlaca());
    }

    @Override
    public String obterLocalizacaoAtual() {
        return "GPS - Caminhão " + getPlaca() + " Latitude: -23.5505, Longitude: -46.6333 | BR-101, km 342";
    }

    public final int getEixos() {
        return eixos;
    }
}
