package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;
import br.edu.logistica.modelo.enuns.StatusVeiculo;

import java.util.List;

public class RelatorioServico {

    private final RepositorioFrota repositorio;

    public RelatorioServico (RepositorioFrota repositorio) {
        this.repositorio = repositorio;
    }

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

    public void gerarRelatorioAutonomia() {
        System.out.println("\n========= RELATÓRIO DE AUTONOMIA =========");
        System.out.printf("%s %s %s %s%n","PLACA", "TIPO", "COMBUSTÍVEL", "AUTONOMIA (km)");
        System.out.println("------------------------------------------");

        repositorio.obterTodos().forEach(v ->
                System.out.printf("%s %s %s %.1f km \n",
                        v.getPlaca(),
                        v.getClass().getSimpleName(),
                        v.getTipoCombustivel(),
                        v.calcularAutonomia())
        );
    }

}
