package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;

/** * Estratégia de cálculo CONSERVADOR de autonomia (-15%). *
 * PADRÃO STRATEGY: * - Implementação concreta da interface CalculadoraAutonomia. * - Reduz autonomia em 15% para critério de segurança. *
 * SOLID (SRP - Single Responsibility): * - Responsável APENAS em calcular autonomia de forma conservadora. */

public class CalculadoraAutonomiaConservadora implements CalculadoraAutonomia {
    @Override
    public double calcular(Veiculo veiculo) {
        // Reduz 15% por segurança
        return veiculo.calcularAutonomia() * 0.85;
    }
}