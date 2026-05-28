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
}
