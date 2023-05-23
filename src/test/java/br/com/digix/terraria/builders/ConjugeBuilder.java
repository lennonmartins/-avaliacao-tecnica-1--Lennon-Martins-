package br.com.digix.terraria.builders;

import br.com.digix.terraria.dominio.Conjuge;
import br.com.digix.terraria.dominio.exceptions.NomeInvalidException;

public class ConjugeBuilder {
    private String nome;

    public ConjugeBuilder() {
        this.nome = "Thiago Teodoro";
    }

    public ConjugeBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Conjuge criar() throws NomeInvalidException{
        return new Conjuge(nome);
    }

}
