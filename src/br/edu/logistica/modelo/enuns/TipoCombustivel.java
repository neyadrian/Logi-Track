package br.edu.logistica.modelo.enuns;

public enum TipoCombustivel {
    DIESEL(5.5), GASOLINA(10.2), ELETRICO(15.0);

    private final double fator;

    TipoCombustivel(double fator) {
        this.fator = fator;
    }

    public double getFator() {
        return fator;
    }
}
