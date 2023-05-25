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

import org.springframework.lang.Nullable;

import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Familia  {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private int pontuacao;

    @Column(nullable = true)
    private double rendaMensal;

    @OneToOne(mappedBy = "familia", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Conjuge conjuge;

    @OneToOne(mappedBy = "familia",  cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Responsavel responsavel;

    @OneToMany(mappedBy = "familia", cascade ={CascadeType.REMOVE, CascadeType.ALL})
    @Nullable
    private List<Dependente> dependentes; 

    public Familia(Conjuge conjuge, Responsavel responsavel, List<Dependente> dependentes, double renda, int pontuacao) throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException {
        validaResponsavel(responsavel);
        validaConjuge(conjuge);
        this.conjuge = conjuge;
        this.responsavel = responsavel;
        this.dependentes = dependentes;
        this.rendaMensal = renda;
        this.pontuacao = pontuacao;
        this.responsavel.setFamilia(this);
        this.conjuge.setFamilia(this);
        for (Dependente dependente : dependentes) {
            dependente.setFamilia(this);
        }
    }

    private void validaConjuge(Conjuge conjuge) throws ConjugeInvalidException {
        if(conjuge == null) throw new ConjugeInvalidException();
    }

    private void validaResponsavel(Responsavel responsavel) throws ResponsavelInvalidException {
        if(responsavel == null) throw new ResponsavelInvalidException();
    }

    public void setPontos(int pontos) {
        this.pontuacao += pontos;
    }
}
