package br.com.digix.terraria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.digix.terraria.dominio.Familia;

@Service
public class CriteriosImplements implements ICriterios {

    private int pontos;

    @Override
    public void validarSeAtendeCriterios(List<Familia> familias) {
        for (Familia familia : familias) {
            int quantidadeDeDependentes = familia.getDependentes().size();
            validarCriterioUm(familia);
            validarCriterioDois(familia);
            validarCriterioTres(familia, quantidadeDeDependentes);
            validarCriterioQuatro(familia, quantidadeDeDependentes);
            adcionaPontosAFamilia(familia, this.pontos);
        }
    }

    private void adcionaPontosAFamilia(Familia familia, int pontos) {
        familia.setPontos(pontos);
    }

    public void validarCriterioUm(Familia familia) {
        int pontos = 5;
        double renadaLimiteMaxima = 900;
        if (familia.getRendaMensal().getRendaMensal() <= renadaLimiteMaxima)
            this.pontos += pontos;
    }

    public void validarCriterioDois(Familia familia) {
        double rendaMaximaLimite = 1500;
        double rendaMinimaLimite = 900;
        int pontos = 3;
        if (familia.getRendaMensal().getRendaMensal() > rendaMinimaLimite
                && familia.getRendaMensal().getRendaMensal() <= rendaMaximaLimite)
            this.pontos += pontos;
    }

    public void validarCriterioTres(Familia familia, int quantidaDeDependentes) {
        int pontos = 3;
        int quantidadeMinimaDeDependentes = 3;
        if (quantidaDeDependentes >= quantidadeMinimaDeDependentes)
            this.pontos += pontos;
    }

    public void validarCriterioQuatro(Familia familia, int quantidaDeDependentes) {
        int pontos = 2;
        int quantidadeMaximaDeDependentes = 3;
        if (quantidaDeDependentes < quantidadeMaximaDeDependentes)
            this.pontos += pontos;
    }
}
