package br.com.digix.terraria.builders;

import java.util.ArrayList;
import java.util.List;

import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.ConjugeInvalidException;
import br.com.digix.terraria.dominio.Dependente;
import br.com.digix.terraria.dominio.DependentesInvalidException;
import br.com.digix.terraria.dominio.Familia;
import br.com.digix.terraria.dominio.NomeInvalidException;
import br.com.digix.terraria.dominio.Renda;
import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dominio.ResponsavelInvalidException;

public class FamiliaBuilder {
    private Conjuge conjuge;
    private Responsavel responsavel;
    private List<Dependente> dependentes;
    private Renda rendaMensal;
    
    public FamiliaBuilder() throws NomeInvalidException {
        this.conjuge = new ConjugeBuilder().criar();
        this.responsavel = new ResponsavelBuilder().criar();
        this.dependentes = new ArrayList<>();
        this.rendaMensal = new RendaBuilder().criar();
    }

    public FamiliaBuilder comResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
        return this;
    }

    public Familia criar() throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
        return new Familia(conjuge, responsavel, dependentes, rendaMensal);
    }

    public FamiliaBuilder comDependente(Dependente dependente) {
        this.dependentes.add(dependente);
        return this;
    }

    public FamiliaBuilder comConjuge(Conjuge conjuge) {
        this.conjuge = conjuge;
        return this;
    }

}
