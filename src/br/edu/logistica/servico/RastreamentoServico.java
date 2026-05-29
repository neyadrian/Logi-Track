package br.edu.logistica.servico;

import br.edu.logistica.modelo.Monitoravel;

import java.util.List;

/** * Serviço de Rastreamento - Responsável por GPS e localização. *
 * PADRÕES SOLID APLICADOS: * - SOLID (SRP - Single Responsibility):  *   Responsável APENAS por rastreamento de veículos. *
 * - SOLID (DIP - Dependency Inversion):  *   Depende da interface Monitoravel (abstração), *   não de implementações concretas (Caminhao). */

public class RastreamentoServico {
     private final RepositorioFrota repositorio;

    public RastreamentoServico(RepositorioFrota repositorio) {
        this.repositorio = repositorio;
    }

    /**     * SRP: Apenas lista veículos monitoráveis.     * DIP: Usa interface Monitoravel, não implementações específicas.     */
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
