package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;

/** * Gerenciador Central da Frota - PADRÃO SINGLETON. *
        * PADRÕES APLICADOS: * ═══════════════════════════════════════════════════════════════ *
        * 1. PADRÃO SINGLETON (Criacional): *    - Garante UMA ÚNICA INSTÂNCIA de GerenciadorFrota. *    - Construtor privado: Impede instanciação direta. *    - getInstance(): Retorna sempre a mesma instância. *    - synchronized: Thread-safe. *
        * 2. SOLID (SRP - Single Responsibility): *    - Responsável por COORDENAR operações de frota. *    - Delega para: RepositorioFrota, RelatorioServico, RastreamentoServico. */

public class GerenciadorFrota {
    private static GerenciadorFrota instancia;

    private final RepositorioFrota repositorio;
    private final RelatorioServico relatorios;
    private final RastreamentoServico rastreamento;
    private final CalculadoraAutonomia calculadora;

    /**     * SINGLETON: Construtor PRIVADO.     * Apenas getInstance() pode criar instância.     */
    private GerenciadorFrota() {
        this.repositorio = new RepositorioFrota();
        this.relatorios = new RelatorioServico(repositorio);
        this.rastreamento = new RastreamentoServico(repositorio);
        this.calculadora = v -> v.calcularAutonomia();
    }

    /**     * SINGLETON: Obtém a única instância de GerenciadorFrota.     * synchronized: Thread-safe para multi-threading.     */
    public static synchronized GerenciadorFrota getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorFrota();
        }
        return instancia;
    }

    /**     * SRP: Delega para repositorio.adicionar().     */
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

    public void listarVeiculosDisponiveis() {
        relatorios.listarVeiculosDisponiveis();
    }

    public void gerarRelatorioAutonomia() {
        relatorios.gerarRelatorioAutonomia();
    }

    public void listarVeiculosMonitoraveis() {
        rastreamento.listarVeiculosMonitoraveis();
    }

    public Veiculo buscarPorPlaca(String placa) {
        return repositorio.buscarPorPlaca(placa);
    }

    public int getTotalVeiculos() {
        return repositorio.getTotalVeiculos();
    }

    public RelatorioServico getRelatorios() { return relatorios; }

    public RastreamentoServico getRastreamento() { return rastreamento; }
}