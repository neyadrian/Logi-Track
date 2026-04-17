# 🚛 LogiTrack  
### Sistema de Gerenciamento de Frota Logística

![Java](https://img.shields.io/badge/Java-17+-orange)
![POO](https://img.shields.io/badge/Paradigma-POO-blue)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

---

## 📖 Sobre o Projeto

O **LogiTrack** é um sistema desenvolvido em Java com o objetivo de simular o gerenciamento de uma frota logística, permitindo o controle de veículos, seus estados e autonomia.

O projeto foi construído com foco na aplicação prática de conceitos fundamentais de **Programação Orientada a Objetos (POO)**.

---

## 🧠 Conceitos Aplicados

✔️ Abstração  
✔️ Herança  
✔️ Polimorfismo  
✔️ Interfaces  
✔️ Enumerações  
✔️ Collections (List e Map)  

---

## 🏗️ Estrutura do Projeto
src/
└── br.edu.logistica
├── aplicacao
│ └── Main.java
│
├── modelo
│ ├── Veiculo.java
│ ├── Caminhao.java
│ ├── Van.java
│ ├── Monitoravel.java
│ └── enums
│ ├── StatusVeiculo.java
│ └── TipoCombustivel.java
│
└── servico
└── GerenciadorFrota.java

---

## 🚗 Funcionalidades

### 🔹 Cadastro de Veículos
Adiciona veículos à frota.

### 🔹 Listagem de Disponíveis
Filtra veículos com status **DISPONIVEL**.

### 🔹 Relatório de Autonomia
Calcula e exibe autonomia com base no combustível.

### 🔹 Busca por Placa
Busca eficiente utilizando `Map<String, Veiculo>`.

### 🔹 Monitoramento
Apenas **Caminhões** possuem rastreamento via satélite.

---

## ⚙️ Regras de Negócio

- Nem todo veículo é monitorável  
- Cada veículo calcula sua autonomia de forma diferente  
- O tipo de combustível impacta diretamente na autonomia  

---

## ⛽ Tipos de Combustível

| Combustível | Fator (km/unidade) |
|------------|------------------|
| DIESEL     | 5.5              |
| GASOLINA   | 10.2             |
| ELETRICO   | 15.0             |

---

## 🚦 Status dos Veículos

- DISPONIVEL  
- EM_MANUTENCAO  
- EM_VIAGEM  

---

## 👨‍💻 Autor
- Ney Adrian
