package br.edu.logistica.aplicacao;

import br.edu.logistica.modelo.Caminhao;
import br.edu.logistica.modelo.Van;
import br.edu.logistica.modelo.Veiculo;
import br.edu.logistica.modelo.enuns.StatusVeiculo;
import br.edu.logistica.modelo.enuns.TipoCombustivel;
import br.edu.logistica.servico.GerenciadorFrota;

public class  Main {
    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("         LogiTrack — Sistema de Frota       ");
        System.out.println("============================================\n");

        GerenciadorFrota gerenciador = new GerenciadorFrota();

        Caminhao c1 = new Caminhao("BRA-2025", 22.0, TipoCombustivel.DIESEL, 3);
        Caminhao c2 = new Caminhao("LOG-4321", 30.0, TipoCombustivel.DIESEL, 5);
        Caminhao c3 = new Caminhao("ECO-0001", 18.0, TipoCombustivel.ELETRICO, 2);

        Van v1 = new Van("VAN-1001", 1.5, TipoCombustivel.GASOLINA, false);
        Van v2 = new Van("VAN-2002", 2.0, TipoCombustivel.GASOLINA, true);
        Van v3 = new Van("VAN-3003", 1.8, TipoCombustivel.ELETRICO, false);

        c2.setStatusVeiculo(StatusVeiculo.EM_VIAGEM);
        v2.setStatusVeiculo(StatusVeiculo.EM_MANUTENCAO);

        System.out.println("── Cadastrando veículos ──");
        gerenciador.adicionarVeiculo(c1);
        gerenciador.adicionarVeiculo(c2);
        gerenciador.adicionarVeiculo(c3);
        gerenciador.adicionarVeiculo(v1);
        gerenciador.adicionarVeiculo(v2);
        gerenciador.adicionarVeiculo(v3);

        gerenciador.adicionarVeiculo(c1);

        gerenciador.exibirFrotaCompleta();

        gerenciador.listarVeiculosDisponiveis();

        gerenciador.gerarRelatorioAutonomia();

        gerenciador.listarVeiculosMonitoraveis();

        System.out.println("\n================ BUSCA POR PLACA ================");

        Veiculo encontrado = gerenciador.buscarPorPlaca("VAN-2002");
        if (encontrado != null) {
            System.out.println("Veículo encontrado:");
            encontrado.exibirInformacoes();
        }

        gerenciador.buscarPorPlaca("XXX-9999");

        System.out.println("\n══════════ POLIMORFISMO EXPLÍCITO ═════════");

        Veiculo[] mix = { c1, v1, c3, v3 };

        System.out.printf("%-12s %-10s %-16s%n", "PLACA", "TIPO REAL", "AUTONOMIA");
        System.out.println("──────────────────────────────────────────");
        for (Veiculo v : mix) {
            System.out.printf("%-12s %-10s %.1f km%n",
                    v.getPlaca(),
                    v.getClass().getSimpleName(),
                    v.calcularAutonomia());
        }

        System.out.println("Total de veículos cadastrados: " + gerenciador.getTotalVeiculos());
        System.out.println("\n Sistema encerrado!");

    }
}