package br.edu.logistica.modelo;

public class Caminhao extends Veiculo{
    private int eixos;

    public Caminhao(String placa, double capacidadeCarga, int eixos) {
        super(placa, capacidadeCarga);
        this.eixos = eixos;
    }

    public double calcularAutonomia() {

    }
}
