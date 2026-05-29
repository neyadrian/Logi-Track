package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;

/** * Estratégia de cálculo OTIMIZADO de autonomia (+10%). *
 * PADRÃO STRATEGY: * - Implementação concreta da interface CalculadoraAutonomia. * - Aumenta autonomia em 10% para cenário otimista. *
 * SOLID (SRP - Single Responsibility): * - Responsável APENAS em calcular autonomia de forma otimizada. */

public class CalculadoraAutonomiaOtimizada implements CalculadoraAutonomia {
    @Override
    public double calcular(Veiculo veiculo) {
        // Adiciona 10% de otimização
        return veiculo.calcularAutonomia() * 1.10;
    }
}