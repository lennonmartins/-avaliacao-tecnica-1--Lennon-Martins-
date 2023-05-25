package br.com.digix.terraria.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.repository.FamiliaRepository;
import br.com.digix.terraria.utils.Comparador;

public class ListagemDeFamiliasService {
    private List<Familia> familias;

    @Autowired
    private ICriterios criteriosMapper;

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private ValidacaoDeCriterioService servico;

    public ListagemDeFamiliasService() {
        this.familias = new ArrayList<>();
        this.servico = new ValidacaoDeCriterioService();
    }

    public void adicionarFamilia(Familia familia) {
        this.familias.add(familia);
    }

    public List<Familia> listarFamilias() {
        return this.familias;
    }

    public void ordernarFamiliasPelaPontuacao() {
        List<Familia> familias = (List<Familia>) buscarTodas();
        servico.validarOsCriteriosAtendidos(familias);
        Collections.sort(this.familias, Comparador.comparador());
    }

    public Collection<Familia> buscarTodas() {
        return ((Collection<Familia>) familiaRepository.findAll());
    }

    // public Collection<Familia>(){

    // }

}
