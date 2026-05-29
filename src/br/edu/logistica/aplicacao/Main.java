package br.edu.logistica.aplicacao;

import br.edu.logistica.modelo.Caminhao;
import br.edu.logistica.modelo.Van;
import br.edu.logistica.modelo.Veiculo;
import br.edu.logistica.modelo.enuns.StatusVeiculo;
import br.edu.logistica.modelo.enuns.TipoCombustivel;
import br.edu.logistica.servico.*;

/** * Classe Principal - Demonstração de todos os padrões implementados. *
 * PADRÕES UTILIZADOS: *
 * 1. PADRÃO SINGLETON: *    - GerenciadorFrota.getInstance() retorna única instância *    - Verificado no final do programa *
 * 2. PADRÃO STRATEGY: *    - 3 estratégias diferentes de cálculo de autonomia: *      a) CalculadoraAutonomiaSimples (valor base, padrão) *      b) CalculadoraAutonomiaConservadora (-15%, segurança) *      c) CalculadoraAutonomiaOtimizada (+10%, eficiência) *    - Mudados via gerenciador.getRelatorios().setEstrategiaCalculo(nova_estrategia) *
 * 3. SOLID PRINCIPLES: *    - SRP: Cada classe com responsabilidade única *    - OCP: Aberto para extensão, fechado para modificação *    - LSP: Polimorfismo com array Veiculo[] *    - ISP: Interface Monitoravel para rastreamento *    - DIP: Dependência em abstrações, não implementações */

public class Main {
    public static void main(String[] args) {

        System.out.println("════════════════════════════════════════════════");
        System.out.println("         LogiTrack — Sistema de Frota           ");
        System.out.println("      Padrão SINGLETON (GerenciadorFrota)      ");
        System.out.println("      Padrão STRATEGY (CalculadoraAutonomia)   ");
        System.out.println("════════════════════════════════════════════════\n");

        // PADRÃO SINGLETON: Obtém a única instância do GerenciadorFrota
        GerenciadorFrota gerenciador = GerenciadorFrota.getInstance();

        Caminhao c1 = new Caminhao("BRA-2025", 22.0, TipoCombustivel.DIESEL, 3);
        Caminhao c2 = new Caminhao("LOG-4321", 30.0, TipoCombustivel.DIESEL, 5);
        Caminhao c3 = new Caminhao("ECO-0001", 18.0, TipoCombustivel.ELETRICO, 2);

        Van v1 = new Van("VAN-1001", 1.5, TipoCombustivel.GASOLINA, false);
        Van v2 = new Van("VAN-2002", 2.0, TipoCombustivel.GASOLINA, true);
        Van v3 = new Van("VAN-3003", 1.8, TipoCombustivel.ELETRICO, false);

        c2.setStatusVeiculo(StatusVeiculo.EM_VIAGEM);
        v2.setStatusVeiculo(StatusVeiculo.EM_MANUTENCAO);

        System.out.println("──────── Cadastrando veículos na frota ────────");
        gerenciador.adicionarVeiculo(c1);
        gerenciador.adicionarVeiculo(c2);
        gerenciador.adicionarVeiculo(c3);
        gerenciador.adicionarVeiculo(v1);
        gerenciador.adicionarVeiculo(v2);
        gerenciador.adicionarVeiculo(v3);

        gerenciador.adicionarVeiculo(c1);

        gerenciador.exibirFrotaCompleta();

        // FILTRAGEM: VEÍCULOS DISPONÍVEIS (SOLID SRP)
        gerenciador.listarVeiculosDisponiveis();

        // STRATEGY #1: AUTONOMIA SIMPLES (Padrão)
        System.out.println("   STRATEGY #1: AUTONOMIA SIMPLES (padrão)      ");
        gerenciador.gerarRelatorioAutonomia();

        // STRATEGY #2: AUTONOMIA CONSERVADORA (-15%)
        System.out.println("   STRATEGY #2: AUTONOMIA CONSERVADORA (-15%)    ");
        gerenciador.getRelatorios()
                .setEstrategiaCalculo(new CalculadoraAutonomiaConservadora());
        gerenciador.gerarRelatorioAutonomia();

        // STRATEGY #3: AUTONOMIA OTIMIZADA (+10%)
        System.out.println("   STRATEGY #3: AUTONOMIA OTIMIZADA (+10%)       ");
        gerenciador.getRelatorios()
                .setEstrategiaCalculo(new CalculadoraAutonomiaOtimizada());
        gerenciador.gerarRelatorioAutonomia();

        gerenciador.listarVeiculosMonitoraveis();

        // BUSCA: Veículos por Placa (SOLID SRP)
        System.out.println("\n================ BUSCA POR PLACA ================");
        Veiculo encontrado = gerenciador.buscarPorPlaca("VAN-2002");
        if (encontrado != null) {
            System.out.println("✓ Veículo encontrado:");
            encontrado.exibirInformacoes();
        }

        System.out.println();
        Veiculo naoEncontrado = gerenciador.buscarPorPlaca("XXX-9999");
        if (naoEncontrado == null) {
            System.out.println("✗ Veículo com placa 'XXX-9999' não foi encontrado.");
        }

        System.out.println("\n══════════ POLIMORFISMO EXPLÍCITO ══════════════");
        System.out.println("Eis uma amostra de veículos da frota:");
        System.out.println();

        Veiculo[] amostra = { c1, v1, c3, v3 };

        System.out.printf("%-12s %-15s %-20s %-15s%n", "PLACA", "TIPO REAL", "COMBUSTÍVEL", "AUTONOMIA");
        System.out.println("───────────────────────────────────────────────────────────────");
        for (Veiculo v : amostra) {
            System.out.printf("%-12s %-15s %-20s %.1f km%n",
                    v.getPlaca(),
                    v.getClass().getSimpleName(),
                    v.getTipoCombustivel().name(),
                    v.calcularAutonomia());
        }

        System.out.println("\n═════════════════ RESUMO FINAL ═════════════════");
        System.out.println("Total de veículos cadastrados: " + gerenciador.getTotalVeiculos());
        System.out.println("Status: ✓ Singleton funcionando (única instância)");
        System.out.println("Status: ✓ Strategy funcionando (3 estratégias aplicadas)");
        System.out.println();

        // TESTE DE SINGLETON
        // Cria segunda referência e verifica se é a mesma instância
        GerenciadorFrota gerenciador2 = GerenciadorFrota.getInstance();
        System.out.println("Teste Singleton:");
        System.out.println("  gerenciador == gerenciador2: " + (gerenciador == gerenciador2));
        System.out.println("  (Deve ser TRUE = mesma instância)");

        System.out.println("           Sistema encerrado com sucesso!        ");
    }
}