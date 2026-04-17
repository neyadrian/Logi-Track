package br.edu.logistica.modelo;

import br.edu.logistica.modelo.enuns.StatusVeiculo;
import br.edu.logistica.modelo.enuns.TipoCombustivel;

public abstract class Veiculo {
    private String placa;
    private double capacidadeCarga;
    private StatusVeiculo statusVeiculo;
    private TipoCombustivel tipoCombustivel;

    public Veiculo(String placa, double capacidadeCarga, TipoCombustivel tipoCombustivel) {
        this.placa = placa;
        this.capacidadeCarga = capacidadeCarga;
        this.tipoCombustivel = tipoCombustivel;
        this.statusVeiculo = StatusVeiculo.DISPONIVEL;
    }

    public abstract double calcularAutonomia();

    public void exibirInformacoes() {
        System.out.println("=== Informações do Veículo ===");
        System.out.println(" Placa: " + placa);
        System.out.println(" Capacidade de Carga: " + capacidadeCarga + " ton");
        System.out.printf (" Combustível    : %-24s \n", tipoCombustivel);
        System.out.printf (" Fator (km/un.) : %-24.1f \n", tipoCombustivel.getFator());
        System.out.println(" Status: " + statusVeiculo);
        System.out.println(" Autonomia estimada: " + calcularAutonomia() + " km");
        System.out.println("==============================");
    }

    public final String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public final double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public final void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public final StatusVeiculo getStatusVeiculo() {
        return statusVeiculo;
    }

    public final void setStatusVeiculo(StatusVeiculo statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }

    public final TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    @Override
    public String toString() {
        return String.format("Veiculo[placa= %s, status= %s, autonomia= %.1f km]",
                placa, statusVeiculo, calcularAutonomia());
    }
}
