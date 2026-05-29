package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;
import br.edu.logistica.modelo.enuns.StatusVeiculo;

import java.util.List;

/** * Serviço de Relatórios - Usa PADRÃO STRATEGY para cálculos. *
 * PADRÕES APLICADOS: * - PADRÃO STRATEGY: Usa diferentes CalculadoraAutonomia via composição. *   Permite trocar estratégia em tempo de execução. *
 * SOLID (SRP - Single Responsibility): * - Responsável APENAS por gerar relatórios. *
 * SOLID (DIP - Dependency Inversion): * - Depende de CalculadoraAutonomia (abstração), *   não das implementações concretas (Simples, Conservadora, Otimizada). */

public class RelatorioServico {

    private final RepositorioFrota repositorio;
    private CalculadoraAutonomia estrategiaCalculo;

    public RelatorioServico(RepositorioFrota repositorio) {
        this.repositorio = repositorio;
        this.estrategiaCalculo = new CalculadoraAutonomiaSimples();
    }

    /**     * STRATEGY: Permite trocar a estratégia de cálculo em tempo de execução.     */
    public void setEstrategiaCalculo(CalculadoraAutonomia estrategia) {
        this.estrategiaCalculo = estrategia;
    }

    /**     * SRP: Apenas lista veículos disponíveis.     */
    public void listarVeiculosDisponiveis() {
        System.out.println("\n========= VEÍCULOS DISPONÍVEIS =========");
        List<Veiculo> disponiveis = repositorio.obterTodos().stream()
                .filter(v -> v.getStatusVeiculo() == StatusVeiculo.DISPONIVEL)
                .toList();

        if (disponiveis.isEmpty()) {
            System.out.println(" Nenhum veículo disponível no momento.");
        } else {
            disponiveis.forEach(v -> System.out.println("  → " + v));
        }
    }

    /**     * SRP: Apenas gera relatório de autonomia.     * Usa a STRATEGY atual para cálculo.     */
    public void gerarRelatorioAutonomia() {
        System.out.println("\n========= RELATÓRIO DE AUTONOMIA =========");
        System.out.printf("%s %s %s %s%n","PLACA", "TIPO", "COMBUSTÍVEL", "AUTONOMIA (km)");
        System.out.println("------------------------------------------");

        repositorio.obterTodos().forEach(v ->
                System.out.printf("%s %s %s %.1f km \n",
                        v.getPlaca(),
                        v.getClass().getSimpleName(),
                        v.getTipoCombustivel(),
                        estrategiaCalculo.calcular(v)) // Usa a estratégia
        );
    }
}