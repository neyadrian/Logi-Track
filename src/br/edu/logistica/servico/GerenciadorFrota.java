package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;
import br.edu.logistica.modelo.enuns.StatusVeiculo;
import br.edu.logistica.modelo.Monitoravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorFrota {

    private final List<Veiculo> frota;
    private final Map<String, Veiculo> indicePorPlaca;

    public GerenciadorFrota() {
        this.frota = new ArrayList<>();
        this.indicePorPlaca = new HashMap<>();
    }

    public void adicionarVeiculo(Veiculo v) {
        if (indicePorPlaca.containsKey(v.getPlaca())) {
            System.out.println("AVISO - Veículo com placa " + v.getPlaca() + " já cadastrado.");
            return;
        }
        frota.add(v);
        indicePorPlaca.put(v.getPlaca(), v);
        System.out.println("Veículo " + v.getPlaca() + " adicionado à frota.");
    }

    public void listarVeiculosDisponiveis() {
        System.out.println("\n========= VEÍCULOS DISPONÍVEIS =========");
        boolean encontrou = false;
        for (Veiculo v : frota) {
            if (v.getStatusVeiculo() == StatusVeiculo.DISPONIVEL) {
                System.out.println("  → " + v);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println(" Nenhum veículo disponível no momento.");
        }
    }

    public void gerarRelatorioAutonomia() {
        System.out.println("\n========= RELATÓRIO DE AUTONOMIA =========");
        System.out.printf("%s %s %s %s%n","PLACA", "TIPO", "COMBUSTÍVEL", "AUTONOMIA (km)");
        System.out.println("------------------------------------------");

        for (Veiculo v : frota) {
            System.out.printf("%s %s %s %.1f km \n",
                    v.getPlaca(),
                    v.getClass().getSimpleName(),
                    v.getTipoCombustivel(),
                    v.calcularAutonomia());
        }
    }

    public Veiculo buscarPorPlaca(String placa) {
        Veiculo encontrado = indicePorPlaca.get(placa);
        if (encontrado == null) {
            System.out.println("Veículo com placa '" + placa + "' não encontrado.");
        }
        return encontrado;
    }

    public void listarVeiculosMonitoraveis() {
        System.out.println("\n========= VEÍCULOS COM RASTREAMENTO =========");
        boolean encontrou = false;
        for (Veiculo v : frota) {
            if (v instanceof Monitoravel monitoravel) {
                monitoravel.enviarCoordenadas();
                System.out.println("  " + monitoravel.obterLocalizacaoAtual());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println(" Nenhum veículo com rastreamento ativo.");
        }
    }

    public void exibirFrotaCompleta() {
        System.out.println("\n========= FROTA COMPLETA=========");
        System.out.println("Total de veículos: " + frota.size());
        System.out.println();
        for (Veiculo v : frota) {
            v.exibirInformacoes();
            System.out.println();
        }
    }

    public final int getTotalVeiculos() {
        return frota.size();
    }
}
