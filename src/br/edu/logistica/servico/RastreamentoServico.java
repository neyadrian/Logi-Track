package br.edu.logistica.servico;

import br.edu.logistica.modelo.Monitoravel;

import java.util.List;

public class RastreamentoServico {
     private final RepositorioFrota repositorio;

    public RastreamentoServico(RepositorioFrota repositorio) {
        this.repositorio = repositorio;
    }

    public void listarVeiculosMonitoraveis() {
        System.out.println("\n========= VEÍCULOS COM RASTREAMENTO =========");
        List<Monitoravel> monitore = repositorio.obterTodos().stream()
                .filter(v -> v instanceof Monitoravel)
                .map(v -> (Monitoravel) v)
                .toList();

        if (monitore.isEmpty()) {
            System.out.println(" Nenhum veículo com rastreamento ativo.");
        } else {
            monitore.forEach(m -> {
                m.enviarCoordenadas();
                System.out.println("  " + m.obterLocalizacaoAtual());
            });
        }
    }
}
