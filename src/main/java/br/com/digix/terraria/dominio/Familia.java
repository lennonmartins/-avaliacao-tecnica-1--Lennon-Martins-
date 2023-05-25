package br.com.digix.terraria.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

@Entity
public class Familia  {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private int pontuacao;

    @OneToOne(mappedBy = "familia", cascade = CascadeType.PERSIST)
    private Conjuge conjuge;

    @OneToOne(mappedBy = "familia")
    private Responsavel responsavel;

    @OneToMany(mappedBy = "familia", cascade ={CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Dependente> dependentes;

    @OneToOne(mappedBy = "familia")
    private Renda rendaMensal;

    // public Familia(Conjuge conjuge, Responsavel responsavel, List<Dependente> dependentes, Renda renda, int pontuacao) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
    //     validaResponsavel(responsavel);
    //     validaConjuge(conjuge);
    //     this.conjuge = conjuge;
    //     this.responsavel = responsavel;
    //     this.dependentes = dependentes;
    //     this.rendaMensal = renda;
    //     this.pontuacao = pontuacao;
    // }

    public Familia(Conjuge conjuge, Responsavel responsavel, List<Dependente> dependentes, Renda renda) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
        validaResponsavel(responsavel);
        validaConjuge(conjuge);
        this.conjuge = conjuge;
        this.responsavel = responsavel;
        this.dependentes = dependentes;
        this.rendaMensal = renda;
    }

    private void validaConjuge(Conjuge conjuge) throws ConjugeInvalidException {
        if(conjuge == null) throw new ConjugeInvalidException();
    }

    private void validaResponsavel(Responsavel responsavel) throws ResponsavelInvalidException {
        if(responsavel == null) throw new ResponsavelInvalidException();
    }

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

    public void setPontos(int pontos) {
        this.pontuacao += pontos;
    }

    
}
