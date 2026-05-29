package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;

/** * Estratégia de cálculo SIMPLES de autonomia. *
 * PADRÃO STRATEGY: * - Implementação concreta da interface CalculadoraAutonomia. * - Calcula autonomia SEM modificadores (valor base). *
 * SOLID (SRP - Single Responsibility): * - Responsável APENAS em calcular autonomia de forma simples. */

public class CalculadoraAutonomiaSimples implements CalculadoraAutonomia {
    @Override
    public double calcular(Veiculo veiculo) {
        return veiculo.calcularAutonomia();
    }
}