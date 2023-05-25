package br.com.digix.terraria.builders;

import br.com.digix.terraria.dominio.Responsavel;
import br.com.digix.terraria.dominio.exceptions.ConjugeInvalidException;
import br.com.digix.terraria.dominio.exceptions.DependentesInvalidException;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;
import br.com.digix.terraria.dominio.exceptions.ResponsavelInvalidException;

public class ResponsavelBuilder {
    private String nome;

    public ResponsavelBuilder() throws ResponsavelInvalidException, ConjugeInvalidException, DependentesInvalidException, NomeInvalidException {
        this.nome = "Lennnon";
    }

    public Responsavel criar() throws NomeInvalidException{
        return new Responsavel(nome); 
    }

    public ResponsavelBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }
}
