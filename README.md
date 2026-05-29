# 🚛 LogiTrack
### Sistema de Gerenciamento de Frota Logística
![Java](https://img.shields.io/badge/Java-17+-orange)
![POO](https://img.shields.io/badge/Paradigma-POO-blue)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

---

## 📖 Sobre o Projeto
O **LogiTrack** é um sistema desenvolvido em Java com o objetivo de simular o gerenciamento de uma frota logística, permitindo o controle de veículos, seus estados e autonomia. O projeto foi construído com foco na aplicação prática de conceitos fundamentais de **Programação Orientada a Objetos (POO)**. É um sistema que gerencia frotas de veículos aplicando padrões de projeto e princípios SOLID.

---

## 🎨 PADRÕES DE PROJETO IMPLEMENTADOS

### SINGLETON - `GerenciadorFrota`
**O que é:** Um padrão que garante apenas UMA instância de uma classe em toda aplicação.
**Onde foi usado:** Na classe `GerenciadorFrota`.
**Para que serve:** - Garantir um único gerenciador de frota.
- Evitar duplicação de dados.
- Fornecer ponto de acesso centralizado e global.

**Como funciona:**
- Construtor privado (não permite `new`).
- Método `getInstance()` retorna sempre a mesma instância.
- Thread-safe com `synchronized`.

**Benefícios:**
- Controla acesso a recurso global.
- Uma única fonte de verdade.
- Economiza memória.
- Garante consistência dos dados.

---

### STRATEGY - `CalculadoraAutonomia`
**O que é:** Um padrão que permite trocar algoritmos em tempo de execução.
**Onde foi usado:**
- Interface: `CalculadoraAutonomia`
- Implementação 1: `CalculadoraAutonomiaSimples`
- Implementação 2: `CalculadoraAutonomiaConservadora`
- Implementação 3: `CalculadoraAutonomiaOtimizada`

**Para que serve:**
- Trocar algoritmo de cálculo sem modificar código existente.
- Suportar múltiplos cenários de cálculo.
- Adicionar novas estratégias facilmente.

**Como funciona:**
- `CalculadoraAutonomiaSimples`: retorna valor base.
- `CalculadoraAutonomiaConservadora`: reduz 15% (mais seguro).
- `CalculadoraAutonomiaOtimizada`: aumenta 10% (mais eficiente).

**Benefícios:**
- Flexibilidade para trocar algoritmo em runtime.
- Cada estratégia isolada e testável.
- Suporta cenários: pessimista, normal, otimista.
- Fácil adicionar novas estratégias.

---

## 🏛️ PRINCÍPIOS SOLID IMPLEMENTADOS

### SRP - Single Responsibility Principle
**O que é:** Cada classe deve ter apenas uma responsabilidade.
**Onde foi aplicado:**
- `Veiculo.java`: Responsável apenas por definir contrato abstrato.
- `Caminhao.java`: Responsável apenas por calcular autonomia de caminhão.
- `Van.java`: Responsável apenas por calcular autonomia de van.
- `RepositorioFrota.java`: Responsável apenas por armazenar dados.
- `RelatorioServico.java`: Responsável apenas por gerar relatórios.
- `RastreamentoServico.java`: Responsável apenas por rastreamento GPS.
- `GerenciadorFrota.java`: Responsável apenas por coordenar serviços.

**Benefícios:**
- Código mais fácil de entender e ler.
- Mais fácil manter e modificar.
- Mais fácil testar.
- Menos efeitos colaterais.

---

### DIP - Dependency Inversion Principle
**O que é:** Classes de alto nível não devem depender de classes de baixo nível. Ambas devem depender de abstrações.
**Onde foi aplicado:**
1. **Com CalculadoraAutonomia:**
   `RelatorioServico` depende de `CalculadoraAutonomia` (interface). Não depende de `CalculadoraAutonomiaSimples` ou outras implementações. Permite trocar implementação sem modificar `RelatorioServico`.

2. **Com Monitoravel:**
   `RastreamentoServico` depende de `Monitoravel` (interface). Não depende de `Caminhao` especificamente. Permite adicionar novos veículos monitoráveis.

3. **Com Veiculo:**
   `GerenciadorFrota` depende de `Veiculo` (abstração). Não depende de `Caminhao` ou `Van` especificamente. Permite adicionar novos tipos de veículos.

**Benefícios:**
- Baixo acoplamento entre classes.
- Fácil trocar implementações.
- Mais testável com mocks.
- Mais flexível e extensível.

---

## 🏗️ ESTRUTURA DO PROJETO

    src/
    └── br.edu.logistica
        ├── aplicacao
        │   └── Main.java
        │
        ├── modelo
        │   ├── Veiculo.java
        │   ├── Caminhao.java
        │   ├── Van.java
        │   ├── Monitoravel.java
        │   └── enums
        │       ├── StatusVeiculo.java
        │       └── TipoCombustivel.java
        │
        └── servico
            ├── GerenciadorFrota.java
            ├── RepositorioFrota.java
            ├── RelatorioServico.java
            ├── RastreamentoServico.java
            ├── CalculadoraAutonomia.java
            ├── CalculadoraAutonomiaSimples.java
            ├── CalculadoraAutonomiaConservadora.java
            └── CalculadoraAutonomiaOtimizada.java

---

## 🧩 CLASSES PRINCIPAIS

- **`GerenciadorFrota` (SINGLETON):** Gerenciador central único da frota. Métodos: `getInstance()`, `adicionarVeiculo()`, `exibirFrotaCompleta()`, `listarVeiculosDisponiveis()`, `gerarRelatorioAutonomia()`, `listarVeiculosMonitoraveis()`, `buscarPorPlaca()`.
- **`RepositorioFrota` (Armazenamento):** Gerencia persistência de dados. Usa `HashMap` para busca rápida por placa. Usa `ArrayList` para manter ordem.
- **`RelatorioServico` (Relatórios):** Gera relatórios de frota. Usa STRATEGY para cálculos. Permite trocar estratégia com `setEstrategiaCalculo()`.
- **`RastreamentoServico` (Rastreamento):** Gerencia rastreamento GPS. Depende de `Monitoravel` (interface). Lista veículos com rastreamento ativo.
- **`CalculadoraAutonomia` (STRATEGY Interface):** Define contrato `calcular(Veiculo)`. Permite implementar novos algoritmos.

---

## 🚗 FUNCIONALIDADES E REGRAS DE NEGÓCIO

### 🔹 Funcionalidades
- **Cadastro de Veículos:** Adiciona veículos à frota.
- **Listagem de Disponíveis:** Filtra veículos com status **DISPONIVEL**.
- **Relatório de Autonomia:** Calcula e exibe autonomia com base no combustível.
- **Busca por Placa:** Busca eficiente utilizando `Map<String, Veiculo>`.
- **Monitoramento:** Apenas **Caminhões** possuem rastreamento via satélite.

### ⚙️ Regras de Negócio
- Nem todo veículo é monitorável.
- Cada veículo calcula sua autonomia de forma diferente.
- O tipo de combustível impacta diretamente na autonomia.

---

## 🚀 COMO USAR

**Obter Gerenciador (SINGLETON):**
GerenciadorFrota gerenciador = GerenciadorFrota.getInstance();

**Adicionar Veículo:**
Caminhao c1 = new Caminhao("BRA-2025", 22.0, TipoCombustivel.DIESEL, 3);
gerenciador.adicionarVeiculo(c1);

**Trocar Estratégia (STRATEGY):**
gerenciador.getRelatorios()
.setEstrategiaCalculo(new CalculadoraAutonomiaConservadora());
gerenciador.gerarRelatorioAutonomia();

**Listar Disponíveis:**
gerenciador.listarVeiculosDisponiveis();

**Buscar por Placa:**
Veiculo v = gerenciador.buscarPorPlaca("BRA-2025");

**Rastreamento:**
gerenciador.listarVeiculosMonitoraveis();

---

## ⛽ TIPOS DE COMBUSTÍVEL
| Combustível | Fator (km/unidade) |
|------------|------------------|
| DIESEL     | 5.5              |
| GASOLINA   | 10.2             |
| ELETRICO   | 15.0             |

---

## 🚦 STATUS DOS VEÍCULOS
- **DISPONIVEL:** Pronto para viagem
- **EM_MANUTENCAO:** Em manutenção
- **EM_VIAGEM:** Em translado

---

## 🧠 CONCEITOS APLICADOS
✔️ Abstração  
✔️ Herança  
✔️ Polimorfismo  
✔️ Interfaces  
✔️ Enumerações  
✔️ Collections (List e Map)  
✔️ Padrão Singleton  
✔️ Padrão Strategy  
✔️ Princípio SRP  
✔️ Princípio DIP

---

## 📝 RESUMO
- **Padrão SINGLETON em `GerenciadorFrota`:** Instância única, acesso centralizado.
- **Padrão STRATEGY em `CalculadoraAutonomia`:** Trocar algoritmos em runtime.
- **Princípio SRP em todas classes:** Responsabilidade única.
- **Princípio DIP em serviços:** Depender de abstrações.

---

## 👨‍💻 Autores
- Ney Adrian, Isaque Almeida, Ronald.