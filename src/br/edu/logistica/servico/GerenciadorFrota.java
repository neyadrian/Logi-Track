package br.edu.logistica.servico;

public class GerenciadorFrota {
    private final RepositorioFrota repositorio;
    private final RelatorioServico relatorios;
    private final RastreamentoServico rastreamento;
    private final CalculadoraAutonomia calculadora;

    public GerenciadorFrotaRefatorado( RepositorioFrota repositorio, RelatorioServico relatorios, RastreamentoServico rastreamento, CalculadoraAutonomia calculadora) {
        this.repositorio = repositorio;
        this.relatorios = relatorios;
        this.rastreamento = rastreamento;
        this.calculadora = calculadora;
    }

}
