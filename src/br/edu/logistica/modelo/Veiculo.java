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

    public abstract double calcularAutonomia();

    public void exibirAutonomia() {
        System.out.println("=== Informações do Veículo ===");
        System.out.println("Placa: " + placa);
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " ton");
        System.out.println("Status: " + statusVeiculo);
        System.out.println("Autonomia estimada: " + calcularAutonomia() + " km");
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public StatusVeiculo getStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
}
