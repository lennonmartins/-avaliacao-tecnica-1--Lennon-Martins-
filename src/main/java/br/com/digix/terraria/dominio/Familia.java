package br.com.digix.terraria.dominio;

import java.util.List;

import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

public class Familia implements Id{
    private long id;
    private int pontuacao;
    private Conjuge conjuge;
    private Responsavel responsavel;
    private List<Dependente> dependentes;
    private Renda rendaMensal;

    public Familia(Conjuge conjuge, Responsavel responsavel, List<Dependente> dependentes, Renda renda, int pontuacao) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
        validaResponsavel(responsavel);
        validaConjuge(conjuge);
        this.conjuge = conjuge;
        this.responsavel = responsavel;
        this.dependentes = dependentes;
        this.rendaMensal = renda;
        this.pontuacao = pontuacao;
    }

    private void validaConjuge(Conjuge conjuge) throws ConjugeInvalidException {
        if(conjuge == null) throw new ConjugeInvalidException();
    }

    private void validaResponsavel(Responsavel responsavel) throws ResponsavelInvalidException {
        if(responsavel == null) throw new ResponsavelInvalidException();
    }

    @Override
    public long getId() {
      return this.id;
    }

    public Responsavel getResponsavel() {
        return this.responsavel;
    }

    public Conjuge getConjuge() {
        return this.conjuge;
    }

    public Renda getRendaMensal() {
        return this.rendaMensal;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public List<Dependente> getDependentes() {
        return this.dependentes;
    }

    public void adicionarPontos(int pontos){
        this.pontuacao += pontos;
    }
    
}
