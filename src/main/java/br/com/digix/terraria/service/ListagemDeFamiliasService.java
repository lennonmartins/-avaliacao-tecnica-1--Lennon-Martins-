package br.com.digix.terraria.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dtos.responses.ListagemResponseDTO;
import br.com.digix.terraria.utils.Comparador;

@Service
public class ListagemDeFamiliasService {
    private List<Familia> familias;

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

    private ListagemResponseDTO familiaParaFamiliaDaListagem (Familia familia) {
        return new ListagemResponseDTO(familia.getResponsavel().getNome(), familia.getPontuacao());
    }

    private Collection<ListagemResponseDTO> ListagemDefamiliaParaListagemDefamiliasResponse(
            Collection<Familia> familias) {
        Collection<ListagemResponseDTO> familiasRetornadasDtos = new ArrayList<>();
        for (Familia familia : familias) {
            familiasRetornadasDtos.add(this.familiaParaFamiliaDaListagem(familia));
        }
        return familiasRetornadasDtos;
    }

    public Collection<ListagemResponseDTO> ordernarFamiliasPelaPontuacao() {
        List<Familia> familias =  servico.pontuarFamiliaPelosCriteriosAtendidos();
        Collections.sort(familias, Comparador.comparador());
        Collection<ListagemResponseDTO> familiasResponse = ListagemDefamiliaParaListagemDefamiliasResponse(familias);
        return familiasResponse;
    }
}
