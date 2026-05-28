package br.edu.logistica.servico;

import br.edu.logistica.modelo.Veiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioFrota {

    private final List<Veiculo> frota;
    private final Map<String, Veiculo> indicePorPlaca;

    public RepositorioFrota() {
        this.frota = new ArrayList<>();
        this.indicePorPlaca = new HashMap<>();
    }

    public void adicionar(Veiculo v) {
        if (indicePorPlaca.containsKey(v.getPlaca())) {
            System.out.println("AVISO - Veículo com placa " + v.getPlaca() + " já cadastrado.");
            return;
        }
        frota.add(v);
        indicePorPlaca.put(v.getPlaca(), v);
    }

    public Veiculo buscarPorPlaca(String placa) {
        return indicePorPlaca.get(placa);
    }

    public List<Veiculo> obterTodos() {
        return new ArrayList<>(frota);
    }

    public int getTotalVeiculos() {
        return frota.size();
    }
}
