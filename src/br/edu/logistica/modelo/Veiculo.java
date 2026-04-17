package br.edu.logistica.modelo;

public abstract class Veiculo {
    private String placa;
    private double capacidadeCarga;
    private StatusVeiculo statusVeiculo;

    public Veiculo(String placa, double capacidadeCarga) {
        this.placa = placa;
        this.capacidadeCarga = capacidadeCarga;
        this.statusVeiculo = StatusVeiculo.DISPONIVEL;
    }

    public enum StatusVeiculo {
        DISPONIVEL, EM_MANUTENCAO, EM_VIAGEM;
    }

    public abstract double calcularAutonimia();
}
