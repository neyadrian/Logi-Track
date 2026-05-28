package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;

public class GerenciadorFrota {
    private final RepositorioFrota repositorio;
    private final RelatorioServico relatorios;
    private final RastreamentoServico rastreamento;
    private final CalculadoraAutonomia calculadora;

    public GerenciadorFrota( RepositorioFrota repositorio, RelatorioServico relatorios, RastreamentoServico rastreamento, CalculadoraAutonomia calculadora) {
        this.repositorio = repositorio;
        this.relatorios = relatorios;
        this.rastreamento = rastreamento;
        this.calculadora = calculadora;
    }

    public void adicionarVeiculo(Veiculo v) {
        repositorio.adicionar(v);
        System.out.println("Veículo " + v.getPlaca() + " adicionado à frota.");
    }

    public void exibirFrotaCompleta() {
        System.out.println("\n========= FROTA COMPLETA=========");
        var veiculos = repositorio.obterTodos();
        System.out.println("Total de veículos: " + veiculos.size());
        System.out.println();
        veiculos.forEach(Veiculo::exibirInformacoes);
    }

    public RelatorioServico getRelatorios() { return relatorios; }

    public RastreamentoServico getRastreamento() { return rastreamento; }
}
