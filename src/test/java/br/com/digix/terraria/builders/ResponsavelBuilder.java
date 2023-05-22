package br.com.digix.terraria.builders;

import br.com.digix.terraria.dominio.NomeInvalidException;
import br.com.digix.terraria.dominio.Responsavel;

public class ResponsavelBuilder {
    private String nome;

    public ResponsavelBuilder() {
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
