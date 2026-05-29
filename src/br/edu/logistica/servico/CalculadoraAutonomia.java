package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;

/** * Interface que define o contrato para strategies de cálculo de autonomia. *
 * PADRÃO STRATEGY (Criacional): * - Define diferentes formas de calcular autonomia sem modificar a classe Veiculo. * - Permite trocar o algoritmo em tempo de execução. *
 * SOLID (DIP - Dependency Inversion Principle): * - RelatorioServico depende desta abstração (interface), *   não de implementações concretas. */

public interface CalculadoraAutonomia {
    double calcular(Veiculo veiculo);
}